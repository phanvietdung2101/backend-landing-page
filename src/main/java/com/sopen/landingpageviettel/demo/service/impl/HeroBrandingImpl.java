package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import com.sopen.landingpageviettel.demo.repository.HeroBrandingRepository;
import com.sopen.landingpageviettel.demo.service.HeroBrandingService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class HeroBrandingImpl implements HeroBrandingService {
    @Autowired
    HeroBrandingRepository heroBrandingRepository;

    @Override
    public ServiceResult getLatest() {
        HeroBranding heroBranding = heroBrandingRepository.findTopByOrderByIdDesc();
        return new ServiceResult(heroBranding, "ok");
    }

    @Override
    public ServiceResult save(HeroBranding heroBranding) {
        try {
            if (heroBranding.getId() != null) {
                heroBranding.setId(null);
            }
            heroBranding = heroBrandingRepository.save(heroBranding);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(heroBranding, "ok");
    }
}
