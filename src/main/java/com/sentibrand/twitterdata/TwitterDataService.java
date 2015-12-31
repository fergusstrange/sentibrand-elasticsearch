package com.sentibrand.twitterdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TwitterDataService {

    private final Logger logger = LoggerFactory.getLogger(TwitterDataService.class);

    private final Client client;
    private final ObjectMapper objectMapper;

    @Autowired
    public TwitterDataService(Client client,
                              ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public List<String> saveOrUpdate(List<TwitterData> twitterDatas) {
        return twitterDatas.parallelStream()
                .map(this::index)
                .collect(toList());
    }

    private String index(TwitterData twitterData) {
        try {
            return client.prepareIndex("twitterdata", "twitterdata")
                    .setSource(objectMapper.writeValueAsBytes(twitterData))
                    .execute()
                    .actionGet()
                    .getId();
        }
        catch (IOException e) {
            logger.error("Unable to serialise twitter data", e);
            throw new RuntimeException(e);
        }
    }
}
