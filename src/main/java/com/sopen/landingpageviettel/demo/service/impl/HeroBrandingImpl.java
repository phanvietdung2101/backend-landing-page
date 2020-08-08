package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import com.sopen.landingpageviettel.demo.repository.HeroBrandingRepository;
import com.sopen.landingpageviettel.demo.service.HeroBrandingService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroBrandingImpl implements HeroBrandingService {
    @Autowired
    HeroBrandingRepository heroBrandingRepository;

    @Override
    public ServiceResult getLatest() {
        HeroBranding heroBranding = heroBrandingRepository.findTopByOrderByIdDesc();
        return new ServiceResult(heroBranding,"ok");
    }

    @Override
    public ServiceResult create(HeroBranding heroBranding) {
        heroBrandingRepository.save(heroBranding);
        return new ServiceResult("ok");
    }
}
