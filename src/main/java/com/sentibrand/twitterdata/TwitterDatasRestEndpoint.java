package com.sentibrand.twitterdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class TwitterDatasRestEndpoint {

    private final TwitterDataService twitterDataService;

    @Autowired
    public TwitterDatasRestEndpoint(TwitterDataService twitterDataService) {
        this.twitterDataService = twitterDataService;
    }

    @RequestMapping(value = "/twitterdatas", method = PUT)
    public ResponseEntity saveOrUpdate(@RequestBody final List<TwitterData> twitterDatas) {
        twitterDataService.saveOrUpdate(twitterDatas);
        return ResponseEntity.ok().build();
    }
}
