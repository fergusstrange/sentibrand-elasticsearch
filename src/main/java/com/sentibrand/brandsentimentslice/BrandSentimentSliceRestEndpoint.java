package com.sentibrand.brandsentimentslice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class BrandSentimentSliceRestEndpoint {

    private final BrandSentimentSliceService brandSentimentSliceService;

    @Autowired
    public BrandSentimentSliceRestEndpoint(BrandSentimentSliceService brandSentimentSliceService) {
        this.brandSentimentSliceService = brandSentimentSliceService;
    }

    @RequestMapping(value = "/brandsentimentslice", method = PUT)
    public ResponseEntity saveOrUpdate(@RequestBody final BrandSentimentSlice brandSentimentSlice) {
        brandSentimentSliceService.saveOrUpdate(brandSentimentSlice);
        return ResponseEntity.ok().build();
    }
}
