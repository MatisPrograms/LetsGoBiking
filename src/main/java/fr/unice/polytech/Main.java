package fr.unice.polytech;

import fr.unice.polytech.map.GeoMap;
import fr.unice.polytech.services.ArrayOfGeoCoordinate;
import fr.unice.polytech.services.GeoCoordinate;
import fr.unice.polytech.services.Itinerary;
import fr.unice.polytech.services.RoutingService;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        // opening a java swing map
        GeoMap map = new GeoMap();

        // Waiting for map to notify
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (map) {
            map.wait();
        }

        // Getting list of wanted waypoints
        List<Waypoint> waypoints = map.getWaypoints().waypoints().keySet().stream().toList();

        // Choosing Origin and Destination Location
        GeoPosition origin;
        if (waypoints.size() > 0) {
            origin = waypoints.get(0).getPosition();
        } else {
            origin = geoPositionManualInput("Origin");
        }
        System.out.printf("Origin: %s, %s\n", origin.getLatitude(), origin.getLongitude());

        GeoPosition destination;
        if (waypoints.size() > 1) {
            destination = waypoints.get(waypoints.size() - 1).getPosition();
        } else {
            destination = geoPositionManualInput("Destination");
        }
        System.out.printf("Destination: %s, %s\n\n", destination.getLatitude(), destination.getLongitude());

        // Ask for directions to routing server
        System.out.println("Asking for directions from " + origin + " to " + destination);
        ArrayOfGeoCoordinate directions = new ArrayOfGeoCoordinate();
        directions.getGeoCoordinate().addAll(waypoints.stream().map(Waypoint::getPosition).map(Main::convert).toList());

        try {
            Itinerary itinerary = new RoutingService().getWSHttpBindingIRoutingService().getItineraryList(directions);
            System.out.println("Directions received from server:" + itinerary);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            map.dispose();
            System.exit(-1);
        }

        // Displaying directions
        List<Object> data = new ArrayList<>();
        map.showDirections(data);
    }

    private static GeoPosition geoPositionManualInput(String text) {
        System.out.println("\nEnter " + text + " Location: ");
        System.out.print("Latitude: ");
        double lat = sc.nextDouble();
        System.out.print("Longitude: ");
        double lon = sc.nextDouble();
        return new GeoPosition(lat, lon);
    }

    static GeoCoordinate convert(GeoPosition position) {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLatitude(position.getLatitude());
        geoCoordinate.setLongitude(position.getLongitude());
        return geoCoordinate;
    }
}