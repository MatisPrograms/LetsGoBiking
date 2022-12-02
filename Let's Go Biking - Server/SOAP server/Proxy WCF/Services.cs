using System.Collections.Generic;
using System.Device.Location;

namespace Proxy_WCF
{
    public class Services : IJCDecauxAPI, IOpenStreetMapAPI
    {
        public static bool VERBOSE = false;
        private static readonly IJCDecauxAPI JCDecaux = new JCDecauxAPI();
        private static readonly IOpenStreetMapAPI OpenStreetMap = new OpenStreetMapAPI();

        public List<Contract> Contracts()
        {
            return JCDecaux.Contracts();
        }

        public List<Station> Stations(string contractName)
        {
            return JCDecaux.Stations(contractName);
        }

        public Station Station(string contractName, string stationName)
        {
            return JCDecaux.Station(contractName, stationName);
        }

        public List<Place> Querry(string querry)
        {
            return OpenStreetMap.Querry(querry);
        }

        public GeoCoordinate GeoCoordinate(string querry)
        {
            return OpenStreetMap.GeoCoordinate(querry);
        }

        public Route Route(GeoCoordinate start, GeoCoordinate end, string transport)
        {
            return OpenStreetMap.Route(start, end, transport);
        }
    }
}