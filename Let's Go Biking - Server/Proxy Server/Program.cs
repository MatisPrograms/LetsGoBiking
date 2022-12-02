using System;
using System.ServiceModel;
using System.ServiceModel.Description;
using Newtonsoft.Json;
using Proxy_WCF;

namespace Proxy_Server
{
    public class Program
    {
        static void Main(string[] args)
        {
            Uri httpUrl = new Uri("http://localhost:8088/ProxyService");

            using (ServiceHost host = new ServiceHost(typeof(Services), httpUrl))
            {
                WSHttpBinding endpoint = new WSHttpBinding(SecurityMode.None);
                endpoint.MaxReceivedMessageSize = int.MaxValue;
                endpoint.MaxBufferPoolSize = int.MaxValue;
                endpoint.OpenTimeout = new TimeSpan(0, 10, 0);
                endpoint.CloseTimeout = new TimeSpan(0, 10, 0);
                endpoint.SendTimeout = new TimeSpan(0, 10, 0);
                endpoint.ReceiveTimeout = new TimeSpan(0, 10, 0);

                host.AddServiceEndpoint(typeof(IJCDecauxAPI), endpoint, "/JCDecaux");
                host.AddServiceEndpoint(typeof(IOpenStreetMapAPI), endpoint, "/OpenStreetMap");

                ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
                smb.HttpGetEnabled = true;
                host.Description.Behaviors.Add(smb);

                ServiceDebugBehavior sdb = host.Description.Behaviors.Find<ServiceDebugBehavior>();
                sdb.IncludeExceptionDetailInFaults = true;

                try
                {
                    host.Open();
                    Console.WriteLine("Proxy Service is running: " + httpUrl);
                    Console.WriteLine("\n<Press any key to terminate>");
                    Console.ReadKey();
                    host.Close();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    Console.WriteLine("\n<Press any key to restart>");
                    Console.ReadKey();
                    Program.Main(null);
                }
            }
        }
    }
}
