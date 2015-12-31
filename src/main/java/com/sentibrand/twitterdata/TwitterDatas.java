package com.sentibrand.twitterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterDatas implements Serializable {

    private final List<TwitterData> twitterData;

    @JsonCreator
    public TwitterDatas(@JsonProperty List<TwitterData> twitterData) {
        this.twitterData = twitterData;
    }

    public List<TwitterData> getTwitterData() {
        return twitterData;
    }
}
