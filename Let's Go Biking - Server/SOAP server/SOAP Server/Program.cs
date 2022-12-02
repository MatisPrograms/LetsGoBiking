using System;
using System.ServiceModel;
using System.ServiceModel.Description;
using SOAP_WCF;

namespace SOAP_Server
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Uri httpUrl = new Uri("http://localhost:8088/RoutingService");

            using (ServiceHost host = new ServiceHost(typeof(RoutingService), httpUrl))
            {
                WSHttpBinding endpoint = new WSHttpBinding(SecurityMode.None);
                endpoint.MaxReceivedMessageSize = int.MaxValue;
                endpoint.MaxBufferPoolSize = int.MaxValue;
                endpoint.OpenTimeout = new TimeSpan(0, 10, 0);
                endpoint.CloseTimeout = new TimeSpan(0, 10, 0);
                endpoint.SendTimeout = new TimeSpan(0, 10, 0);
                endpoint.ReceiveTimeout = new TimeSpan(0, 10, 0);
                host.AddServiceEndpoint(typeof(IRoutingService), endpoint, "");

                ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
                smb.HttpGetEnabled = true;
                host.Description.Behaviors.Add(smb);

                ServiceDebugBehavior sdb = host.Description.Behaviors.Find<ServiceDebugBehavior>();
                sdb.IncludeExceptionDetailInFaults = true;

                try
                {
                    host.Open();
                    Console.WriteLine("SOAP Service is running: " + httpUrl);
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

            /*// Create a Connection Factory.
            Uri connecturi = new Uri("activemq:tcp://localhost:61616");
            ConnectionFactory connectionFactory = new ConnectionFactory(connecturi);

            // Create a single Connection from the Connection Factory.
            IConnection connection = connectionFactory.CreateConnection();
            connection.Start();

            // Create a session from the Connection.
            ISession session = connection.CreateSession();

            // Use the session to target a queue.
            IDestination destination = session.GetQueue("test");

            // Create a Producer targetting the selected queue.
            IMessageProducer producer = session.CreateProducer(destination);

            // You may configure everything to your needs, for instance:
            producer.DeliveryMode = MsgDeliveryMode.NonPersistent;

            // Finally, to send messages:
            ITextMessage message = session.CreateTextMessage("Hello World 2");
            producer.Send(message);

            Console.WriteLine("Message sent, check ActiveMQ web interface to confirm.");
            Console.ReadLine();

            // Don't forget to close your session and connection when finished.
            session.Close();
            connection.Close();*/
        }
    }
}
