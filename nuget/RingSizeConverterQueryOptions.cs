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
        /// The ring size to convert (provide either size or measurement)
        /// Example: 7
        /// </summary>
        [JsonProperty("size")]
        public string Size { get; set; }

        /// <summary>
        /// Source region: us, uk, eu, jp, ch (china), or au (required with size)
        /// Example: us
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Ring diameter in millimeters (provide either size or measurement)
        /// Example: 17.3
        /// </summary>
        [JsonProperty("measurement")]
        public string Measurement { get; set; }
    }
}
