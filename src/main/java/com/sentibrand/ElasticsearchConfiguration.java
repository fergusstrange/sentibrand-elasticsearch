package com.sentibrand;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.net.InetAddress;

@Configuration
@Profile("!embedded-es")
public class ElasticsearchConfiguration {

    @Value("${elastic.cluster.name:elasticsearch_ferguss}")
    private String clusterName;

    @Bean
    public Client client() {
        return new TransportClient(ImmutableSettings.builder().put("cluster.name", clusterName).build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getLoopbackAddress(), 9300));
    }
}
