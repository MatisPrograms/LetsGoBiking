package fr.unice.polytech;

import fr.unice.polytech.map.GeoMap;
import fr.unice.polytech.services.ArrayOfGeoCoordinate;
import fr.unice.polytech.services.GeoCoordinate;
import fr.unice.polytech.services.Itinerary;
import fr.unice.polytech.services.RoutingService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import javax.jms.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws JMSException {
        // opening a java swing map
        new GeoMap();
        readActiveMQMessages();
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
            Itinerary itinerary = new RoutingService().getWSHttpBindingIRoutingService().getItineraryList(directions);
            System.out.println("Directions received from server:");
            System.out.println("Total distance: " + String.format("%.2f", itinerary.getDistance() / 1000) + "km ↑" + String.format("%.2f", itinerary.getAscend()) + "m ↓" + String.format("%.2f", itinerary.getDescend()) + "m");
            System.out.println("Total time: " + String.format("%.2f", itinerary.getDuration() / 1000 / 60) + "min");

            // Displaying directions
            map.showDirections(itinerary);
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

    static GeoCoordinate convert(GeoPosition position) {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLatitude(position.getLatitude());
        geoCoordinate.setLongitude(position.getLongitude());
        return geoCoordinate;
    }

    private static void readActiveMQMessages() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = factory.createConnection("admin", "admin");
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination dest = new ActiveMQTopic("Let's Go Biking");

        MessageConsumer consumer = session.createConsumer(dest);
        long start = System.currentTimeMillis();
        long count = 1;
        System.out.println("Waiting for messages...");
        while (true) {
            Message msg = consumer.receive();
            if (msg instanceof TextMessage) {
                String body = ((TextMessage) msg).getText();
                if ("SHUTDOWN".equals(body)) {
                    long diff = System.currentTimeMillis() - start;
                    System.out.printf("Received %d in %.2f seconds%n", count, (1.0 * diff / 1000.0));
                    break;
                } else {
                    if (count != msg.getIntProperty("id")) {
                        System.out.println("mismatch: " + count + "!=" + msg.getIntProperty("id"));
                    }
                    count = msg.getIntProperty("id");
                    if (count == 0) {
                        start = System.currentTimeMillis();
                    }
                    if (count % 1000 == 0) {
                        System.out.printf("Received %d messages.%n", count);
                    }
                    count++;
                }
            } else {
                System.out.println("Unexpected message type: " + msg.getClass());
            }
        }
        connection.close();
    }
}