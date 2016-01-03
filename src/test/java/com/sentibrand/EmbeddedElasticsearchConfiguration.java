package com.sentibrand;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("embedded-es")
public class EmbeddedElasticsearchConfiguration {

    @Bean
    public Client client(Node node) {
        return node.client();
    }

    @Bean
    public Node node() {
        return NodeBuilder.nodeBuilder()
                .clusterName("testCluster")
                .local(true)
                .settings(ImmutableSettings.builder()
                        .put("path.home", ".elasticdata")
                        .build())
                .build()
                .start();
    }
}
