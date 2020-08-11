package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.FeatureCarouselSection;
import com.sopen.landingpageviettel.demo.service.FeatureCarouselSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/feature-carousel-section/")
public class FeatureCarouselSectionController extends GeneralController<FeatureCarouselSection> {
    @Autowired
    FeatureCarouselSectionService featureCarouselSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return featureCarouselSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody FeatureCarouselSection featureCarouselSection) {
        return featureCarouselSectionService.save(featureCarouselSection);
    }
}
