package com.sentibrand.brandsentimentslice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandSentimentSlice implements Serializable {

    private final ZonedDateTime dateTime;
    private final double averageSentiment;
    private final List<String> keys;

    @JsonCreator
    public BrandSentimentSlice(@JsonProperty("dateTime") ZonedDateTime dateTime,
                               @JsonProperty("averageSentiment") double averageSentiment,
                               @JsonProperty("keys") List<String> keys) {
        this.dateTime = dateTime;
        this.averageSentiment = averageSentiment;
        this.keys = keys;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public double getAverageSentiment() {
        return averageSentiment;
    }

    public List<String> getKeys() {
        return keys;
    }
}
