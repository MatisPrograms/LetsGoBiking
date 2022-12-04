using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;
using Newtonsoft.Json;
using SOAP_WCF.ProxyServices;
using System;
using System.Collections.Generic;
using System.Device.Location;
using System.Linq;
using System.ServiceModel;

namespace SOAP_WCF
{
    public class RoutingService : IRoutingService
    {
        private static readonly Dictionary<Contract, GeoCoordinate> contracts = new Dictionary<Contract, GeoCoordinate>();

        private static JCDecauxAPIClient JCD;
        private static OpenStreetMapAPIClient OSM;

        private static IConnection connection;
        private static ISession session;
        private static IMessageProducer message;

        static RoutingService()
        {
            // Allowing messages of more than 65 536 bytes
            WSHttpBinding binding = new WSHttpBinding(SecurityMode.None);
            binding.MaxReceivedMessageSize = int.MaxValue;
            binding.MaxBufferPoolSize = int.MaxValue;

            JCD = new JCDecauxAPIClient(binding, new EndpointAddress("http://localhost:8088/ProxyService/JCDecaux"));
            OSM = new OpenStreetMapAPIClient(binding, new EndpointAddress("http://localhost:8088/ProxyService/OpenStreetMap"));

            // Setting up ActiveMQ Producer
            connection = new ConnectionFactory(new Uri("activemq:tcp://localhost:61616")).CreateConnection();
            connection.Start();
            session = connection.CreateSession();

            message = session.CreateProducer(session.GetQueue("Let's Go Biking"));
            message.DeliveryMode = MsgDeliveryMode.NonPersistent;
        }

        static string prettify(string jsonString)
        {
            return JsonConvert.SerializeObject(JsonConvert.DeserializeObject(jsonString), Formatting.Indented);
        }

        private GeoCoordinate Coordinate(Contract contract)
        {
            if (!contracts.ContainsKey(contract)) contracts.Add(contract, OSM.GeoCoordinate(contract.name));
            return contracts[contract];
        }

        private GeoCoordinate Coordinate(Station station)
        {
            return new GeoCoordinate(station.position.lat, station.position.lng);
        }

        private Tuple<Station, Station, Contract> ClosestStation(GeoCoordinate a, GeoCoordinate b, List<Contract> contracts)
        {
            Tuple<Station, Station, Contract> closest = null;
            double minDistance = double.MaxValue;
            foreach (Contract contract in contracts)
            {
                if (JCD.Stations(contract.name) == null) continue;

                Station[] stations = JCD.Stations(contract.name).Where(station => station.status == "OPEN").ToArray();
                if (stations.Length == 0) continue;

                Station[] stationsA = stations.Where(station => station.available_bikes > 0).OrderBy(station => a.GetDistanceTo(Coordinate(station))).ToArray();
                if (stationsA.Length == 0) continue;

                Station[] stationsB = stations.Where(station => station.available_bike_stands > 0).OrderBy(station => b.GetDistanceTo(Coordinate(station))).ToArray();
                if (stationsB.Length == 0) continue;

                Station stationA = stationsA.First();
                Station stationB = stationsB.First();
                if (stationA == stationB) continue;

                GeoCoordinate geoA = Coordinate(stationA);
                GeoCoordinate geoB = Coordinate(stationB);

                double distance = a.GetDistanceTo(geoA) + geoA.GetDistanceTo(geoB) + geoB.GetDistanceTo(b);
                if (distance < minDistance)
                {
                    minDistance = distance;
                    closest = new Tuple<Station, Station, Contract>(stationA, stationB, contract);
                }
            }
            return closest;
        }

        private Itinerary Generate(Path[] routes)
        {
            Itinerary itinerary = new Itinerary();
            foreach (Path r in routes)
            {
                itinerary.bbox = itinerary.bbox == null ? r.bbox : new double[] { Math.Min(itinerary.bbox[0], r.bbox[0]), Math.Min(itinerary.bbox[1], r.bbox[1]), Math.Max(itinerary.bbox[2], r.bbox[2]), Math.Max(itinerary.bbox[3], r.bbox[3]) };
                itinerary.distance += r.distance;
                itinerary.duration += r.time;
                itinerary.ascend += r.ascend;
                itinerary.descend += itinerary.descend;

                List<GeoCoordinate> coordinates = new List<GeoCoordinate>();
                foreach (double[] coord in r.points.coordinates)
                {
                    coordinates.Add(new GeoCoordinate(coord[1], coord[0]));
                }
                itinerary.coordinates = itinerary.coordinates == null ? coordinates.ToArray() : itinerary.coordinates.Concat(coordinates).ToArray();

                List<Step> instructions = new List<Step>();
                foreach (Instruction instruction in r.instructions)
                {
                    instructions.Add(new Step()
                    {
                        text = instruction.text,
                        distance = instruction.distance,
                        duration = instruction.time,
                        street_name = instruction.street_name,
                    });
                }
                itinerary.steps = itinerary.steps == null ? instructions.ToArray() : itinerary.steps.Concat(instructions).ToArray();
            }
            return itinerary;
        }

        public Itinerary GetItineraryList(GeoCoordinate[] coordinates)
        {
            if (coordinates.Length < 2) return null;
            List<Contract> contractsJCDecaux = JCD.Contracts().ToList();
            contractsJCDecaux.RemoveAll(c => c.commercial_name == null || c.cities == null || c.country_code == null);            
            
            Tuple<Station, Station, Contract> closestStations = ClosestStation(coordinates[0], coordinates[coordinates.Length - 1], contractsJCDecaux);
            if (closestStations == null)
            {
                Console.WriteLine("No station found");

                // Ask for route from A to B by foot
                Path route = OSM.Route(coordinates[0], coordinates[coordinates.Length - 1], "foot").paths.First();
                Itinerary itinerary = this.Generate(new Path[] { route });
                message.Send(session.CreateTextMessage(JsonConvert.SerializeObject(itinerary)));
                return itinerary;
            }
            else
            {
                Console.WriteLine("Station found: " + closestStations.Item1.name + " - " + closestStations.Item2.name);

                // Ask for route from A to stationA by foot
                Path route1 = OSM.Route(coordinates[0], Coordinate(closestStations.Item1), "foot").paths.First();

                // Ask for route from stationA to stationB by bike
                Path route2 = OSM.Route(Coordinate(closestStations.Item1), Coordinate(closestStations.Item2), "bike").paths.First();

                // Ask for route from stationB to B by foot
                Path route3 = OSM.Route(Coordinate(closestStations.Item2), coordinates[coordinates.Length - 1], "foot").paths.First();

                Itinerary itinerary = this.Generate(new Path[] { route1, route2, route3 });
                message.Send(session.CreateTextMessage(JsonConvert.SerializeObject(itinerary)));
                return itinerary;
            }
        }

        public Itinerary GetItinerary(GeoCoordinate origin, GeoCoordinate destination)
        {
            return GetItineraryList(new GeoCoordinate[] { origin, destination });
        }
    }
}
