package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.BusinessFeature;
import com.sopen.landingpageviettel.demo.models.BusinessSection;
import com.sopen.landingpageviettel.demo.repository.BusinessFeatureRepository;
import com.sopen.landingpageviettel.demo.repository.BusinessSectionRepository;
import com.sopen.landingpageviettel.demo.service.BusinessSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
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
        return new ServiceResult(businessSection, "ok");
    }

    @Override
    public ServiceResult save(BusinessSection businessSection) {
        try {
            businessSection = saveBusinessSectionTransaction(businessSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(businessSection, "ok");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class)
    BusinessSection saveBusinessSectionTransaction(BusinessSection businessSection) {
        if (businessSection.getId() != null) {
            long id = businessSection.getId();
            businessSection.setId(null);
            businessSectionRepository.deleteById(id);
        }
        businessSection = businessSectionRepository.save(businessSection);
        List<BusinessFeature> businessFeatureList = businessSection.getBusinessFeatureList();
        for (BusinessFeature businessFeature : businessFeatureList) {
            businessFeature.setBusinessSection(businessSection);
            businessFeatureRepository.save(businessFeature);
        }
        return businessSection;
    }
}
