package fr.unice.polytech;

import fr.unice.polytech.map.GeoMap;
import fr.unice.polytech.services.ArrayOfGeoCoordinate;
import fr.unice.polytech.services.GeoCoordinate;
import fr.unice.polytech.services.Itinerary;
import fr.unice.polytech.services.RoutingService;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // opening a java swing map
        new GeoMap();
    }

    public static void calculateItinerary(GeoMap map) {
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
            List<Itinerary> itineraries = new RoutingService().getWSHttpBindingIRoutingService().getItineraryList(directions).getItinerary();
            if (itineraries == null) {
                System.err.println("No itineraries found");
                return;
            }
            for (Itinerary itinerary : itineraries) {
                System.out.println("Directions received from server:");
                System.out.println("Total distance: " + distance(itinerary.getDistance()) + " ↑" + distance(itinerary.getAscend()) + " ↓" + distance(itinerary.getDescend()));
                System.out.println("Total time: " + time(itinerary.getDuration()));
            }

            // Displaying directions
            map.showDirections(itineraries);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            map.dispose();
            System.exit(-1);
        }
    }

    private static GeoPosition geoPositionManualInput(String text) {
        System.out.println("\nEnter " + text + " Location: ");
        System.out.print("Latitude: ");
        double lat = sc.nextDouble();
        System.out.print("Longitude: ");
        double lon = sc.nextDouble();
        return new GeoPosition(lat, lon);
    }

    private static GeoCoordinate convert(GeoPosition position) {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLatitude(position.getLatitude());
        geoCoordinate.setLongitude(position.getLongitude());
        return geoCoordinate;
    }

    private static String distance(double distance) {
        if (distance < 1000) {
            return String.format("%.2f", distance) + "m";
        } else {
            return String.format("%.2f", distance / 1000) + "km";
        }
    }

    private static String time(double time) {
        time /= 1000;
        if (time < 60) {
            return String.format("%.2f", time) + "s";
        } else if (time < 3600) {
            return String.format("%.2f", time / 60) + "min";
        } else {
            return String.format("%.2f", time / 3600) + "h";
        }
    }
}