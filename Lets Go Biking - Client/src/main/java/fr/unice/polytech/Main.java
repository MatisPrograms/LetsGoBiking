package fr.unice.polytech;

import fr.unice.polytech.map.GeoMap;
import fr.unice.polytech.services.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import javax.jms.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static IRoutingService ITINERARY_SERVICE;

    public static void main(String[] args) {
        // opening a java swing map
        new Thread(() -> activeMQ(new GeoMap())).start();
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
        System.out.printf("Origin: %.2f, %.2f\n", origin.getLatitude(), origin.getLongitude());

        GeoPosition destination;
        if (waypoints.size() > 1) {
            destination = waypoints.get(waypoints.size() - 1).getPosition();
        } else {
            destination = geoPositionManualInput("Destination");
        }
        System.out.printf("Destination: %.2f, %.2f\n\n", destination.getLatitude(), destination.getLongitude());

        // Ask for directions to routing server
        System.out.println("Asking for directions from " + origin + " to " + destination);
        if (ITINERARY_SERVICE == null) ITINERARY_SERVICE = new RoutingService().getWSHttpBindingIRoutingService();
        if (map.isActivatingMQ()) {
            ITINERARY_SERVICE.liveItinerary(convert(origin), convert(destination));
            System.out.println("Waiting for message in ActiveMQ");
        } else {
            ArrayOfGeoCoordinate directions = new ArrayOfGeoCoordinate();
            directions.getGeoCoordinate().addAll(waypoints.stream().map(Waypoint::getPosition).map(Main::convert).toList());
            try {
                List<Itinerary> itineraries = ITINERARY_SERVICE.getItineraryList(directions).getItinerary();
                if (itineraries == null) {
                    System.err.println("No itineraries found");
                    return;
                }
                for (Itinerary itinerary : itineraries) {
                    printInformationItinerary(itinerary);
                }

                // Displaying directions
                map.showDirections(itineraries);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                map.dispose();
                System.exit(-1);
            }
        }
    }

    private static void printInformationItinerary(Itinerary itinerary) {
        System.out.println("Directions received from server:");
        System.out.println("Total distance: " + distance(itinerary.getDistance()) + " ↑" + distance(itinerary.getAscend()) + " ↓" + distance(itinerary.getDescend()));
        System.out.println("Total time: " + time(itinerary.getDuration()));
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

    private static void activeMQ(GeoMap map) {
        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connectionFactory.setTrustAllPackages(true);

            // Create a Connection
            Connection connection = connectionFactory.createConnection("admin", "admin");
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = new ActiveMQQueue("Let's Go Biking");

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(message -> {
                try {
                    if (message instanceof TextMessage textMessage) {
                        System.out.println("Received message: " + textMessage.getText());
                        System.err.println("Method not Implemented: @TODO Deserialize message into Itinerary");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // when map exits we close the connection
            map.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    try {
                        consumer.close();
                        session.close();
                        connection.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            while (true) ;
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}