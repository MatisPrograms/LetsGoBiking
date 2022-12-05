package fr.unice.polytech.map;

import fr.unice.polytech.Main;
import fr.unice.polytech.services.GeoCoordinate;
import fr.unice.polytech.services.Itinerary;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;

public class GeoMap extends JFrame {

    private static final GeoPosition ANTIBES = new GeoPosition(43.5804, 7.1164);
    private static final int DEFAULT_ZOOM = 12;

    private final MapViewer jXMapViewer = new MapViewer();
    private final JComboBox<String> comboMapType = new JComboBox<>();
    private final JButton addWaypoint = new JButton("Add Waypoint");
    private final JButton clearWaypoints = new JButton("Clear Waypoints");

    private final JButton calculateRoute = new JButton("Calculate Route");
    private final Waypoints waypoints = new Waypoints();
    private boolean addingWaypoint = false;

    public GeoMap() {
        super("GeoMap - Choisir un point de départ et d'arrivée");

        try {
            Arrays.stream(UIManager.getInstalledLookAndFeels()).filter(laf -> laf.getName().equals("Windows")).forEach(laf -> {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ignored) {
        }

        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.75), (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.75));
        this.setLocationRelativeTo(null);

        this.initJXMapViewer();
        this.initComponents();
        this.initMap();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initJXMapViewer() {
        this.jXMapViewer.setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo()));
        this.jXMapViewer.setAddressLocation(ANTIBES);
        this.jXMapViewer.setZoom(DEFAULT_ZOOM);

        MouseInputListener mouseInputListener = new PanMouseInputListener(this.jXMapViewer);
        this.jXMapViewer.addMouseListener(mouseInputListener);
        this.jXMapViewer.addMouseMotionListener(mouseInputListener);
        this.jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(this.jXMapViewer));

        // print mouse coords on click
        this.jXMapViewer.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (addingWaypoint) {
                    Waypoint waypoint = new DefaultWaypoint(jXMapViewer.convertPointToGeoPosition(e.getPoint()));
                    waypoints.add(waypoint);
                    jXMapViewer.add(waypoints.waypoints().get(waypoint));
                    jXMapViewer.repaint();
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
            }
        });
    }

    private void initComponents() {
        this.comboMapType.setModel(new DefaultComboBoxModel<>(new String[]{"Open Street", "Virtual Earth", "Hybrid", "Satellite"}));
        this.comboMapType.addActionListener(this::changeMapMode);

        this.addWaypoint.addActionListener(this::addWaypoint);
        this.clearWaypoints.addActionListener(this::clearWaypoints);
        this.calculateRoute.addActionListener(this::calculateRoute);
    }

    /**
     * Help from <a href="https://github.com/DJ-Raven/java-sample-jxmapviewer/tree/main/part%201/java-map">...</a>
     */
    private void initMap() {
        this.jXMapViewer.setOverlayPainter(this.waypoints);

        GroupLayout jXMapViewerLayout = new GroupLayout(this.jXMapViewer);
        jXMapViewerLayout.setHorizontalGroup(
                jXMapViewerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(this.addWaypoint)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                                .addComponent(this.clearWaypoints)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                                .addComponent(this.calculateRoute)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 800, Short.MAX_VALUE)
                                .addComponent(this.comboMapType, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jXMapViewerLayout.setVerticalGroup(
                jXMapViewerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jXMapViewerLayout.createSequentialGroup()
                                .addGroup(jXMapViewerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.comboMapType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.addWaypoint)
                                        .addComponent(this.clearWaypoints)
                                        .addComponent(this.calculateRoute))
                                .addContainerGap(600, Short.MAX_VALUE)
                        ));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(this.jXMapViewer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()
                        ));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(this.jXMapViewer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()
                        ));

        this.jXMapViewer.setLayout(jXMapViewerLayout);
        this.pack();
    }

    private void waypointButtonColour(boolean addingWaypoint) {
        if (addingWaypoint) {
            this.addWaypoint.setBackground(new Color(152, 251, 152));
        } else {
            this.addWaypoint.setBackground(null);
        }
        this.update(this.getGraphics());
    }

    private void addWaypoint(ActionEvent actionEvent) {
        this.addingWaypoint = !this.addingWaypoint;
        this.waypointButtonColour(this.addingWaypoint);
    }

    private void clearWaypoints(ActionEvent actionEvent) {
        new Thread(() -> {
            this.clearWaypoints.setBackground(new Color(255, 104, 99));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.clearWaypoints.setBackground(null);
        }).start();

        Arrays.stream(this.jXMapViewer.getComponents()).filter(c -> c.getCursor().getType() == Cursor.HAND_CURSOR).forEach(this.jXMapViewer::remove);
        this.waypoints.waypoints().clear();
        this.jXMapViewer.setItinerary(null);
        this.update(this.getGraphics());
    }

    private void changeMapMode(ActionEvent actionEvent) {
        int index = this.comboMapType.getSelectedIndex();
        TileFactoryInfo info = switch (index) {
            case 1 -> new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
            case 2 -> new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
            case 3 -> new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
            default -> new OSMTileFactoryInfo();
        };
        info.setDefaultZoomLevel(this.jXMapViewer.getZoom());
        this.jXMapViewer.setTileFactory(new DefaultTileFactory(info));
    }

    private void calculateRoute(ActionEvent actionEvent) {
        new Thread(() -> {
            this.calculateRoute.setBackground(new Color(250, 200, 130));
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.calculateRoute.setBackground(null);
        }).start();

        this.addingWaypoint = false;
        this.waypointButtonColour(false);

        if (this.waypoints.waypoints().isEmpty()) this.setVisible(false);
        Main.calculateItinerary(this);
        this.update(this.getGraphics());
    }

    public void showDirections(Itinerary itinerary) {
        this.setTitle(this.getTitle() + " | Distance: " + String.format("%.2f", itinerary.getDistance() / 1000) + "Km");
        if (!this.isVisible()) this.setVisible(true);

        this.jXMapViewer.setItinerary(itinerary);
        this.update(this.getGraphics());
    }

    public Waypoints getWaypoints() {
        return waypoints;
    }
}