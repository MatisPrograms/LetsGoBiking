using System.Collections.Generic;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace Proxy_WCF
{
    [ServiceContract]
    public interface IJCDecauxAPI
    {
        [OperationContract]
        List<Contract> Contracts();

        [OperationContract]
        List<Station> Stations(string contractName);
    }

    [DataContract]
    public class Contract
    {
        [DataMember]
        public string name { get; set; }

        [DataMember]
        public string commercial_name { get; set; }

        [DataMember]
        public string[] cities { get; set; }

        [DataMember]
        public string country_code { get; set; }
    }

    [DataContract]
    public class Station
    {
        [DataMember]
        public int number { get; set; }

        [DataMember]
        public string contract_name { get; set; }

        [DataMember]
        public string name { get; set; }

        [DataMember]
        public string address { get; set; }

        [DataMember]
        public Position position { get; set; }

        [DataMember]
        public bool banking { get; set; }

        [DataMember]
        public bool bonus { get; set; }

        [DataMember]
        public int bike_stands { get; set; }

        [DataMember]
        public int available_bike_stands { get; set; }

        [DataMember]
        public int available_bikes { get; set; }

        [DataMember]
        public string status { get; set; }

        [DataMember]
        public long last_update { get; set; }
    }

    [DataContract]
    public class Position
    {
        [DataMember]
        public float lat { get; set; }

        [DataMember]
        public float lng { get; set; }
    }
}
