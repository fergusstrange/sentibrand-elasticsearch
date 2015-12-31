package com.sentibrand;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@Profile("!embedded-es")
public class ElasticsearchConfiguration {

    @Bean
    public Client client() throws UnknownHostException {
        return TransportClient.builder()
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getLocalHost(), 9200));
    }
}
