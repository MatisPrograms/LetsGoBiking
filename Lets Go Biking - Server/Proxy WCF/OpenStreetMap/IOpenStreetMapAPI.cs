using System.Collections.Generic;
using System.Device.Location;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace Proxy_WCF
{
    [ServiceContract]
    public interface IOpenStreetMapAPI
    {
        [OperationContract]
        List<Place> Querry(string querry);

        [OperationContract]
        GeoCoordinate GeoCoordinate(string querry);

        [OperationContract]
        Route Route(GeoCoordinate start, GeoCoordinate end, string transport);

        [OperationContract]
        string[] Address(double lat, double lng);
    }


    [DataContract]
    public class Place
    {
        [DataMember]
        public long place_id { get; set; }

        [DataMember]
        public string licence { get; set; }

        [DataMember]
        public string osm_type { get; set; }

        [DataMember]
        public long osm_id { get; set; }

        [DataMember]
        public string[] boundingbox { get; set; }

        [DataMember]
        public string lat { get; set; }

        [DataMember]
        public string lon { get; set; }

        [DataMember]
        public string display_name { get; set; }

        [DataMember]
        public long place_rank { get; set; }

        [DataMember]
        public string category { get; set; }

        [DataMember]
        public string type { get; set; }

        [DataMember]
        public double importance { get; set; }

        [DataMember]
        public string icon { get; set; }

        public GeoCoordinate Coordinate() => new GeoCoordinate(double.Parse(lat), double.Parse(lon));
    }

    [DataContract]
    public class Route
    {
        [DataMember]
        public Hints hints { get; set; }

        [DataMember]
        public Info info { get; set; }

        [DataMember]
        public Path[] paths { get; set; }
    }

    [DataContract]
    public class Hints
    {
        [DataMember]
        public long visited_nodessum { get; set; }

        [DataMember]
        public double visited_nodesaverage { get; set; }
    }

    [DataContract]
    public class Info
    {
        [DataMember]
        public string[] copyrights { get; set; }

        [DataMember]
        public long took { get; set; }
    }

    [DataContract]
    public class Path
    {
        [DataMember]
        public double distance { get; set; }

        [DataMember]
        public double weight { get; set; }

        [DataMember]
        public long time { get; set; }

        [DataMember]
        public long transfers { get; set; }

        [DataMember]
        public double[] bbox { get; set; }

        [DataMember]
        public Points points { get; set; }

        [DataMember]
        public Instruction[] instructions { get; set; }

        [DataMember]
        public double ascend { get; set; }

        [DataMember]
        public double descend { get; set; }
    }

    [DataContract]
    public class Instruction
    {
        [DataMember]
        public double distance { get; set; }

        [DataMember]
        public double heading { get; set; }

        [DataMember]
        public long sign { get; set; }

        [DataMember]
        public int[] interval { get; set; }

        [DataMember]
        public string text { get; set; }

        [DataMember]
        public long time { get; set; }

        [DataMember]
        public string street_name { get; set; }

        [DataMember]
        public long exit_number { get; set; }

        [DataMember]
        public bool exited { get; set; }

        [DataMember]
        public double turn_angle { get; set; }

        [DataMember]
        public string street_ref { get; set; }

        [DataMember]
        public double last_heading { get; set; }
    }

    [DataContract]
    public class Points
    {
        [DataMember]
        public double[][] coordinates { get; set; }
    }
}
