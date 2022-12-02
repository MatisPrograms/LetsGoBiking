using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Device.Location;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Runtime.Caching;
using System.Threading.Tasks;

namespace Proxy_WCF
{
    internal class OpenStreetMapAPI : IOpenStreetMapAPI
    {
        private static readonly HttpClient client = new HttpClient();
        private static readonly MemoryCache memoryCache = new MemoryCache("ProxyCache");
        private static readonly DateTimeOffset dt_default = ObjectCache.InfiniteAbsoluteExpiration;

        private static readonly string apiUrlOSM = "https://nominatim.openstreetmap.org/search.php?q=";
        private static readonly string jsonFormatOSM = "&format=jsonv2";

        private static readonly string apiUrlGH = "https://graphhopper.com/api/1/route?vehicle=";
        private static readonly string keyGH = "LijBPDQGfu7Iiq80w3HzwB4RUDJbMbhs6BU0dEnn";
        private static readonly string apiKeyGH = "&key=" + keyGH;
        private static readonly string paramsGH = apiKeyGH + "&locale=fr-FR" + "&instructions=true" + "&return_snapped_waypoints=false" + "&points_encoded=false";

        public OpenStreetMapAPI()
        {
            client.DefaultRequestHeaders.UserAgent.Add(new ProductInfoHeaderValue("OpenStreetMapUA", "1.0"));
        }

        static private async Task<string> getFromUrlAsync(string url)
        {
            if (memoryCache.Contains(url))
            {
                Console.WriteLine(url + ": Fetched from Cache");
                return (string)memoryCache.GetCacheItem(url).Value;
            }
            else
            {
                Console.WriteLine(url);
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                string responseText = await response.Content.ReadAsStringAsync();
                memoryCache.Set(url, responseText, dt_default);

                if (Services.VERBOSE) Console.WriteLine(JsonConvert.SerializeObject(JsonConvert.DeserializeObject(responseText), Formatting.Indented));
                return responseText;
            }
        }

        public List<Place> Querry(string querry)
        {
            return JsonConvert.DeserializeObject<List<Place>>(getFromUrlAsync(apiUrlOSM + querry + jsonFormatOSM).Result);
        }


        public GeoCoordinate GeoCoordinate(string place)
        {
            Place returnedPlace = Querry(place).First();
            return returnedPlace == null ? null : returnedPlace.Coordinate();
        }

        public Route Route(GeoCoordinate start, GeoCoordinate end, string transport)
        {
            string positions = "&point=" + start.Latitude + "%2C" + start.Longitude + "&point=" + end.Latitude + "%2C" + end.Longitude;
            return JsonConvert.DeserializeObject<Route>(getFromUrlAsync(apiUrlGH + transport + paramsGH + positions).Result);
        }
    }
}
