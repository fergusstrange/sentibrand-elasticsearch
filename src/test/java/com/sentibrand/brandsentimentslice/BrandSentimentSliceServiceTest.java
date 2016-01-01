package com.sentibrand.brandsentimentslice;

import com.sentibrand.SentibrandElasticsearchStarter;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.time.ZonedDateTime.now;
import static java.util.Collections.singletonList;
import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SentibrandElasticsearchStarter.class)
public class BrandSentimentSliceServiceTest {

    @Autowired
    private BrandSentimentSliceService brandSentimentSliceService;
    @Autowired
    private Client client;

    @Test
    public void shouldCreateBrandSentimentSlice() throws Exception {
        String id = brandSentimentSliceService.saveOrUpdate(new BrandSentimentSlice(now(), 1.0D, singletonList("Manchester")));

        assertTrue(client.prepareGet("brandsentimentslice", "brandsentimentslice", id)
                .get()
                .isExists());
    }
}