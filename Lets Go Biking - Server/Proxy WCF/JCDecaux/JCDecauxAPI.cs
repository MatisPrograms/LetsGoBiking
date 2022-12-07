using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Runtime.Caching;
using System.Threading.Tasks;

namespace Proxy_WCF
{
    public class JCDecauxAPI : IJCDecauxAPI
    {
        private static readonly HttpClient client = new HttpClient();
        private static readonly MemoryCache memoryCache = new MemoryCache("ProxyCache");
        private static readonly DateTimeOffset dt_default = ObjectCache.InfiniteAbsoluteExpiration;

        private static readonly string key = "c07978fd6796aa1988ad021ca42bdeaee4bf1ea0";
        private static readonly string apiKey = "&apiKey=" + key;
        private static readonly string apiUrl = "https://api.jcdecaux.com/vls/v1";

        static private async Task<string> getFromUrlAsync(string url)
        {
            url = apiUrl + url + apiKey;
            if (memoryCache.Contains(url))
            {
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

        public List<Contract> Contracts()
        {
            try
            {
                return JsonConvert.DeserializeObject<List<Contract>>(getFromUrlAsync("/contracts?").Result);
            }
            catch
            {
                return null;
            }
        }

        public List<Station> Stations(string contractName)
        {
            try
            {
                return JsonConvert.DeserializeObject<List<Station>>(getFromUrlAsync("/stations?contract=" + contractName).Result);
            }
            catch
            {
                return null;
            }
        }
    }
}
