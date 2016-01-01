package com.sentibrand.twitterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterData implements Serializable {

    private final Long id;
    private final String text;
    private final Double sentiment;
    private final ZonedDateTime dateTime;

    @JsonCreator
    public TwitterData(@JsonProperty("id") Long id,
                       @JsonProperty("text") String text,
                       @JsonProperty("sentiment") Double sentiment, ZonedDateTime dateTime) {
        this.id = id;
        this.text = text;
        this.sentiment = sentiment;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Double getSentiment() {
        return sentiment;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }
}
