package com.sentibrand.twitterdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/twitterdatas")
public class TwitterDatasRestEndpoint {

    private final TwitterDataService twitterDataService;

    @Autowired
    public TwitterDatasRestEndpoint(TwitterDataService twitterDataService) {
        this.twitterDataService = twitterDataService;
    }

    @RequestMapping(method = PUT)
    public ResponseEntity saveOrUpdate(@RequestBody final TwitterDatas twitterDatas) {
        twitterDataService.saveOrUpdate(twitterDatas.getTwitterData());
        return ResponseEntity.ok().build();
    }
}
