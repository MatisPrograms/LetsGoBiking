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

    private Itinerary itinerary;
    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
        this.repaint();
    }

    private void drawRoute(Path2D path, List<GeoCoordinate> coordinateList) {
        boolean first = true;
        for (GeoCoordinate coordinate : coordinateList) {
            if (coordinate == this.itinerary.getFromStation().getValue() || coordinate == this.itinerary.getToStation().getValue()) {
                System.out.println("Station: " + coordinate.getLatitude() + ", " + coordinate.getLongitude());
            }
            Point2D point = this.convertGeoPositionToPoint(new GeoPosition(coordinate.getLatitude(), coordinate.getLongitude()));
            point.setLocation(point.getX(), point.getY());
            if (first) {
                path.moveTo(point.getX(), point.getY());
                first = false;
            } else {
                path.lineTo(point.getX(), point.getY());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.itinerary != null) {
            // Set up graphics
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set up route
            Path2D path = new Path2D.Double();
            this.drawRoute(path, this.itinerary.getCoordinates().getValue().getGeoCoordinate());

            // Set up colour
            g2d.setColor(new Color(0, 176, 255));
            g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            // Draw
            g2d.draw(path);
            g2d.dispose();
        }
    }
}
