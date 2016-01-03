package com.sentibrand.twitterdata;

import com.sentibrand.SentibrandElasticsearchStarter;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static java.time.ZonedDateTime.now;
import static java.util.Collections.singletonList;
import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SentibrandElasticsearchStarter.class)
@ActiveProfiles("embedded-es")
public class TwitterDataServiceTest {

    @Autowired
    private TwitterDataService twitterDataService;
    @Autowired
    private Client client;

    @Test
    public void shouldSaveTwitterData() throws Exception {
        List<String> ids = twitterDataService.saveOrUpdate(singletonList(new TwitterData(12345L,
                "Some random tweet",
                2D,
                now())));

        assertTrue(client.prepareGet("twitterdata", "twitterdata", ids.get(0))
                .get()
                .isExists());
    }
}