package com.sentibrand.twitterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterData implements Serializable {

    private final Long id;
    private final String text;
    private final Double sentiment;

    @JsonCreator
    public TwitterData(@JsonProperty Long id,
                       @JsonProperty String text,
                       @JsonProperty Double sentiment) {
        this.id = id;
        this.text = text;
        this.sentiment = sentiment;
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

    @Override
    public String toString() {
        return "TwitterData{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sentiment=" + sentiment +
                '}';
    }
}
