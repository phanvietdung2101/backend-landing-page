package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.BusinessFeature;
import com.sopen.landingpageviettel.demo.models.FeatureCarousel;
import com.sopen.landingpageviettel.demo.models.FeatureCarouselSection;
import com.sopen.landingpageviettel.demo.repository.FeatureCarouselRepository;
import com.sopen.landingpageviettel.demo.repository.FeatureCarouselSectionRepository;
import com.sopen.landingpageviettel.demo.repository.FeatureProgressRepository;
import com.sopen.landingpageviettel.demo.service.FeatureCarouselSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureCarouselSectionServiceImpl implements FeatureCarouselSectionService {
    @Autowired
    FeatureCarouselSectionRepository featureCarouselSectionRepository;

    @Autowired
    FeatureCarouselRepository featureCarouselRepository;

    @Override
    public ServiceResult getLatest() {
        FeatureCarouselSection featureCarouselSection = featureCarouselSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(featureCarouselSection,"ok");
    }

    @Override
    public ServiceResult save(FeatureCarouselSection featureCarouselSection) {
        featureCarouselSection = featureCarouselSectionRepository.save(featureCarouselSection);
        // save business feature list
        List<FeatureCarousel> featureCarouselList = featureCarouselSection.getFeatureCarouselList();
        for (FeatureCarousel featureCarousel : featureCarouselList) {
            featureCarousel.setFeatureCarouselSection(featureCarouselSection);
            // save business feature
            featureCarouselRepository.save(featureCarousel);
        }
        return new ServiceResult(featureCarouselSection,"ok");
    }
}
