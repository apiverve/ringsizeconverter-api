// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     RingSizeConverterData data = Converter.fromJsonString(jsonString);

package com.apiverve.ringsizeconverter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static RingSizeConverterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(RingSizeConverterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(RingSizeConverterData.class);
        writer = mapper.writerFor(RingSizeConverterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// RingSizeConverterData.java

package com.apiverve.ringsizeconverter.data;

import com.fasterxml.jackson.annotation.*;

public class RingSizeConverterData {
    private double inputDiameterMm;
    private double circumferenceMm;
    private Conversions conversions;
    private String note;

    @JsonProperty("input_diameter_mm")
    public double getInputDiameterMm() { return inputDiameterMm; }
    @JsonProperty("input_diameter_mm")
    public void setInputDiameterMm(double value) { this.inputDiameterMm = value; }

    @JsonProperty("circumference_mm")
    public double getCircumferenceMm() { return circumferenceMm; }
    @JsonProperty("circumference_mm")
    public void setCircumferenceMm(double value) { this.circumferenceMm = value; }

    @JsonProperty("conversions")
    public Conversions getConversions() { return conversions; }
    @JsonProperty("conversions")
    public void setConversions(Conversions value) { this.conversions = value; }

    @JsonProperty("note")
    public String getNote() { return note; }
    @JsonProperty("note")
    public void setNote(String value) { this.note = value; }
}

// Conversions.java

package com.apiverve.ringsizeconverter.data;

import com.fasterxml.jackson.annotation.*;

public class Conversions {
    private double diameterMm;
    private double circumferenceMm;
    private long us;
    private String uk;
    private long eu;
    private long jp;
    private long ch;
    private String au;

    @JsonProperty("diameter_mm")
    public double getDiameterMm() { return diameterMm; }
    @JsonProperty("diameter_mm")
    public void setDiameterMm(double value) { this.diameterMm = value; }

    @JsonProperty("circumference_mm")
    public double getCircumferenceMm() { return circumferenceMm; }
    @JsonProperty("circumference_mm")
    public void setCircumferenceMm(double value) { this.circumferenceMm = value; }

    @JsonProperty("us")
    public long getUs() { return us; }
    @JsonProperty("us")
    public void setUs(long value) { this.us = value; }

    @JsonProperty("uk")
    public String getUk() { return uk; }
    @JsonProperty("uk")
    public void setUk(String value) { this.uk = value; }

    @JsonProperty("eu")
    public long getEu() { return eu; }
    @JsonProperty("eu")
    public void setEu(long value) { this.eu = value; }

    @JsonProperty("jp")
    public long getJp() { return jp; }
    @JsonProperty("jp")
    public void setJp(long value) { this.jp = value; }

    @JsonProperty("ch")
    public long getCh() { return ch; }
    @JsonProperty("ch")
    public void setCh(long value) { this.ch = value; }

    @JsonProperty("au")
    public String getAu() { return au; }
    @JsonProperty("au")
    public void setAu(String value) { this.au = value; }
}