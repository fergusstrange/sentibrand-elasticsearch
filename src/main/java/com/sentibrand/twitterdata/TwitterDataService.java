package com.sentibrand.twitterdata;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TwitterDataService {

    private final Client client;

    @Autowired
    public TwitterDataService(Client client) {
        this.client = client;
    }

    public List<String> saveOrUpdate(List<TwitterData> twitterData) {
        return twitterData.parallelStream()
                .map(twitterData1 -> client.prepareIndex("twitterdata", "twitterdata")
                        .setSource(twitterData)
                        .execute()
                        .actionGet()
                        .getId())
                .collect(Collectors.toList());
    }
}
