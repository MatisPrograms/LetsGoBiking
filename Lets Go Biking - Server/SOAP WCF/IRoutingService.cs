using System.Device.Location;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace SOAP_WCF
{
    [ServiceContract]
    public interface IRoutingService
    {
        [OperationContract]
        Itinerary[] GetItineraryList(GeoCoordinate[] coordinates);

        [OperationContract]
        Itinerary GetItinerary(GeoCoordinate origin, GeoCoordinate destination);
    }

    [DataContract]
    public class Itinerary
    {
        [DataMember]
        public double[] bbox { get; set; }

        [DataMember]
        public double distance { get; set; }

        [DataMember]
        public double duration { get; set; }

        [DataMember]
        public double ascend { get; set; }

        [DataMember]
        public double descend { get; set; }

        [DataMember]
        public GeoCoordinate[] coordinates { get; set; }

        [DataMember]
        public Step[] steps { get; set; }

        [DataMember]
        public GeoCoordinate fromStation { get; set; }

        [DataMember]
        public GeoCoordinate toStation { get; set; }
    }
    
    [DataContract]
    public class Step
    {
        [DataMember]
        public string text { get; set; }

        [DataMember]
        public double distance { get; set; }

        [DataMember]
        public double duration { get; set; }

        [DataMember]
        public string street_name { get; set; }
    }
}
