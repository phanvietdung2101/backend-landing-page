package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.FeatureCarousel;
import com.sopen.landingpageviettel.demo.models.FeatureCarouselSection;
import com.sopen.landingpageviettel.demo.repository.FeatureCarouselRepository;
import com.sopen.landingpageviettel.demo.repository.FeatureCarouselSectionRepository;
import com.sopen.landingpageviettel.demo.service.FeatureCarouselSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
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
        return new ServiceResult(featureCarouselSection, "ok");
    }

    @Override
    public ServiceResult save(FeatureCarouselSection featureCarouselSection) {
        try {
            featureCarouselSection = saveFeatureCarouselSectionTransaction(featureCarouselSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(featureCarouselSection, "ok");
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class)
    FeatureCarouselSection saveFeatureCarouselSectionTransaction(FeatureCarouselSection featureCarouselSection) {
        if (featureCarouselSection.getId() == null) {
            featureCarouselSection = featureCarouselSectionRepository.save(featureCarouselSection);
        }
        List<FeatureCarousel> featureCarouselList = featureCarouselSection.getFeatureCarouselList();
        for (FeatureCarousel featureCarousel : featureCarouselList) {
            featureCarousel.setFeatureCarouselSection(featureCarouselSection);
            featureCarouselRepository.save(featureCarousel);
        }
        return featureCarouselSection;
    }


}
