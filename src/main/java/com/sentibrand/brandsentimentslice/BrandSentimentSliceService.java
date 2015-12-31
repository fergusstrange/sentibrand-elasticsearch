package com.sentibrand.brandsentimentslice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BrandSentimentSliceService {

    private static final Logger logger = LoggerFactory.getLogger(BrandSentimentSliceService.class);

    private final Client client;
    private final ObjectMapper objectMapper;

    @Autowired
    public BrandSentimentSliceService(Client client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public String saveOrUpdate(BrandSentimentSlice brandSentimentSlice) {
        try {
            return client.prepareIndex("brandsentimentslice", "brandsentimentslice")
                    .setSource(objectMapper.writeValueAsBytes(brandSentimentSlice))
                    .execute()
                    .actionGet()
                    .getId();
        }
        catch (IOException e) {
            logger.error("Unable to index brand sentiment slice", e);
            throw new RuntimeException(e);
        }
    }
}
