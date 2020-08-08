package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.BusinessFeature;
import com.sopen.landingpageviettel.demo.models.BusinessSection;
import com.sopen.landingpageviettel.demo.repository.BusinessFeatureRepository;
import com.sopen.landingpageviettel.demo.repository.BusinessSectionRepository;
import com.sopen.landingpageviettel.demo.service.BusinessSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessSectionServiceImpl implements BusinessSectionService {
    @Autowired
    BusinessSectionRepository businessSectionRepository;

    @Autowired
    BusinessFeatureRepository businessFeatureRepository;

    @Override
    public ServiceResult getLatest() {
        BusinessSection businessSection = businessSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(businessSection,"ok");
    }

    @Override
    public ServiceResult create(BusinessSection businessSection) {
        businessSectionRepository.save(businessSection);
        // save business feature list
        List<BusinessFeature> businessFeatureList = businessSection.getBusinessFeatureList();
        businessFeatureList.forEach(businessFeature -> {
            businessFeature.setBusinessSection(businessSection);
            // save business feature
            businessFeatureRepository.save(businessFeature);
        });
        return new ServiceResult("ok");
    }
}
