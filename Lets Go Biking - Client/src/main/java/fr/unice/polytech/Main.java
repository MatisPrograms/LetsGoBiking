package fr.unice.polytech;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.map.GeoMap;
import fr.unice.polytech.services.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

import javax.jms.*;
import java.util.ArrayList;
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
        // Formatting distance
        return String.format("%.2f", distance < 1000 ? distance : distance / 1000) + (distance < 1000 ? "m" : "km");
    }

    private static String time(double time) {
        // Time in seconds
        time /= 1000;

        // Formatting time
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
            // Creating a Connection to ActiveMQ
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connectionFactory.setTrustAllPackages(true);
            Connection connection = connectionFactory.createConnection("admin", "admin");
            connection.start();

            // Creating a Session and Selecting the Queue
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("Let's Go Biking");
            MessageConsumer consumer = session.createConsumer(destination);

            // Action to do when receiving a message
            consumer.setMessageListener(message -> {
                try {
                    if (message instanceof TextMessage textMessage) {
                        System.out.println("Received message: " + textMessage.getText());

                        List<Itinerary> itineraries = new ArrayList<>();
                        itineraries.add(deserializeItinerary(textMessage.getText()));
                        map.showDirections(itineraries);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // When map closes, we close the connection
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
        }
    }

    private static Itinerary deserializeItinerary(String msg) {
        try {
            // Parsing the message into Itinerary
            Itinerary itinerary = new Itinerary();
            ObjectFactory factory = new ObjectFactory();
            JsonNode jsonNode = new ObjectMapper().readTree(msg);

            // Setting primitive type variables
            itinerary.setDistance(jsonNode.get("distance").asDouble());
            itinerary.setDuration(jsonNode.get("duration").asDouble());
            itinerary.setAscend(jsonNode.get("ascend").asDouble());
            itinerary.setDescend(jsonNode.get("descend").asDouble());

            // Setting JAXBElement type variables
            itinerary.setBbox(factory.createItineraryBbox(factory.createArrayOfdouble()));
            jsonNode.get("bbox").forEach(d -> itinerary.getBbox().getValue().getDouble().add(d.asDouble()));

            itinerary.setCoordinates(factory.createItineraryCoordinates(factory.createArrayOfGeoCoordinate()));
            jsonNode.get("coordinates").forEach(c -> {
                GeoCoordinate geoCoordinate = new GeoCoordinate();
                geoCoordinate.setLatitude(c.get("Latitude").asDouble());
                geoCoordinate.setLongitude(c.get("Longitude").asDouble());
                itinerary.getCoordinates().getValue().getGeoCoordinate().add(geoCoordinate);
            });

            itinerary.setFromStation(factory.createItineraryFromStation(factory.createGeoCoordinate()));
            itinerary.getFromStation().getValue().setLatitude(jsonNode.get("fromStation").get("Latitude").asDouble());
            itinerary.getFromStation().getValue().setLongitude(jsonNode.get("fromStation").get("Longitude").asDouble());

            itinerary.setToStation(factory.createItineraryToStation(factory.createGeoCoordinate()));
            itinerary.getToStation().getValue().setLatitude(jsonNode.get("toStation").get("Latitude").asDouble());
            itinerary.getToStation().getValue().setLongitude(jsonNode.get("toStation").get("Longitude").asDouble());

            itinerary.setSteps(factory.createItinerarySteps(factory.createArrayOfStep()));
            jsonNode.get("steps").forEach(s -> {
                Step step = new Step();
                step.setText(factory.createString(s.get("text").asText()));
                step.setStreetName(factory.createString(s.get("street_name").asText()));
                step.setDistance(s.get("distance").asDouble());
                step.setDuration(s.get("duration").asDouble());
                itinerary.getSteps().getValue().getStep().add(step);
            });

            return itinerary;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}