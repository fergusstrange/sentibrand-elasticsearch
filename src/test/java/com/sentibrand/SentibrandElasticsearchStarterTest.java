package com.sentibrand;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SentibrandElasticsearchStarterTest {

    @Test
    public void shouldStartWebApplication() throws Exception {
        SentibrandElasticsearchStarter.main();

        HttpStatus statusCode = new RestTemplate()
                .getForEntity("http://localhost:8888/health", String.class)
                .getStatusCode();

        assertThat(statusCode.value(), is(200));
    }
}