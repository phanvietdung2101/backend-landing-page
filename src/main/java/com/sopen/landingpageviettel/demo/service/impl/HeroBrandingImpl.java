package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import com.sopen.landingpageviettel.demo.repository.HeroBrandingRepository;
import com.sopen.landingpageviettel.demo.service.HeroBrandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroBrandingImpl implements HeroBrandingService {
    @Autowired
    HeroBrandingRepository heroBrandingRepository;

    @Override
    public List<HeroBranding> getAll() {
        return heroBrandingRepository.findAll();
    }

    @Override
    public HeroBranding getLatest() {
        return heroBrandingRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(HeroBranding heroBranding) {
        heroBrandingRepository.save(heroBranding);
    }
}
