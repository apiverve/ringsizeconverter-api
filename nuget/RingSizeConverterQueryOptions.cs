using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.RingSizeConverter
{
    /// <summary>
    /// Query options for the Ring Size Converter API
    /// </summary>
    public class RingSizeConverterQueryOptions
    {
        /// <summary>
        /// The ring size to convert
        /// </summary>
        [JsonProperty("size")]
        public string Size { get; set; }

        /// <summary>
        /// Source region
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }
    }
}
