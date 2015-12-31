package com.sentibrand;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("embedded-es")
public class EmbeddedElasticsearchConfiguration {

    @Bean
    public Client client() {
        return NodeBuilder.nodeBuilder()
                .clusterName("testCluster")
                .local(true)
                .settings(Settings.builder()
                        .put("path.home", ".elasticdata")
                        .build())
                .build()
                .start()
                .client();
    }
}
