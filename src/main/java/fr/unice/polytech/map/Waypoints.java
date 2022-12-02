package fr.unice.polytech.map;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Waypoints extends WaypointPainter<Waypoint> {

    private final Map<Waypoint, JButton> waypoints = new HashMap<>();

    private static JButton generateWaypoint() {
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(new File("src/main/resources/waypoint.png").getAbsolutePath()));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setSize(new Dimension(24, 24));
        return button;
    }

    public void add(Waypoint waypoint) {
        this.waypoints.put(waypoint, Waypoints.generateWaypoint());
    }

    public Map<Waypoint, JButton> waypoints() {
        return this.waypoints;
    }

    @Override
    protected void doPaint(Graphics2D g, JXMapViewer map, int width, int height) {
        super.doPaint(g, map, width, height);
        for (Map.Entry<Waypoint, JButton> entry : this.waypoints.entrySet()) {
            Waypoint wp = entry.getKey();
            JButton button = entry.getValue();

            Point2D p = map.getTileFactory().geoToPixel(wp.getPosition(), map.getZoom());
            Rectangle rec = map.getViewportBounds();

            button.setLocation((int) (p.getX() - rec.getX() - button.getWidth() / 2),
                    (int) (p.getY() - rec.getY() - button.getHeight()));
        }
    }
}
