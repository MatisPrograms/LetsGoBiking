package fr.unice.polytech.map;

import fr.unice.polytech.services.GeoCoordinate;
import fr.unice.polytech.services.Itinerary;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.List;

public class MapViewer extends JXMapViewer {

    public static final double DISTANCE = 0.0001;
    public static final Color FOOT = new Color(0, 176, 255);
    private static final Color BIKE = new Color(0, 123, 178);
    private List<Itinerary> itineraries;

    public void setItinerary(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
        this.repaint();
    }

    private void drawRoute(Path2D path, List<GeoCoordinate> coordinateList) {
        boolean first = true;
        for (GeoCoordinate coordinate : coordinateList) {
            Point2D point = this.convertGeoPositionToPoint(new GeoPosition(coordinate.getLatitude(), coordinate.getLongitude()));
            if (first) {
                path.moveTo(point.getX(), point.getY());
                first = false;
            } else {
                path.lineTo(point.getX(), point.getY());
            }
        }
    }

    private boolean isCloseTo(GeoCoordinate a, GeoCoordinate b) {
        return Math.abs(a.getLatitude() - b.getLatitude()) < DISTANCE && Math.abs(a.getLongitude() - b.getLongitude()) < DISTANCE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.itineraries == null) return;
        for (Itinerary itinerary : this.itineraries) {
            if (itinerary != null) {
                // Set up graphics
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                // Separate list of coordinates into sublist before fromStation, between fromStation and toStation, and after toStation
                List<GeoCoordinate> coordinates = itinerary.getCoordinates().getValue().getGeoCoordinate();
                GeoCoordinate from = itinerary.getFromStation().getValue();
                GeoCoordinate to = itinerary.getToStation().getValue();

                if (from != null && to != null) {
                    int indexA = 0;
                    for (GeoCoordinate coordinate : coordinates) {
                        if (isCloseTo(coordinate, from)) break;
                        indexA++;
                    }

                    Path2D pathA = new Path2D.Double();
                    this.drawRoute(pathA, coordinates.subList(0, Math.min(indexA + 1, coordinates.size())));
                    g2d.setColor(FOOT);
                    g2d.draw(pathA);

                    if (indexA < coordinates.size()) {
                        int indexB = indexA;
                        for (GeoCoordinate coordinate : coordinates.subList(indexA, coordinates.size())) {
                            if (isCloseTo(coordinate, to)) break;
                            indexB++;
                        }

                        Path2D pathB = new Path2D.Double();
                        this.drawRoute(pathB, coordinates.subList(indexA, Math.min(indexB + 1, coordinates.size())));
                        g2d.setColor(BIKE);
                        g2d.draw(pathB);

                        Path2D pathC = new Path2D.Double();
                        this.drawRoute(pathC, coordinates.subList(Math.min(indexB, coordinates.size()), coordinates.size()));
                        g2d.setColor(FOOT);
                        g2d.draw(pathC);
                    }
                } else {
                    Path2D path = new Path2D.Double();
                    this.drawRoute(path, coordinates);
                    g2d.setColor(FOOT);
                    g2d.draw(path);
                }
                g2d.dispose();
            }
        }
    }
}
