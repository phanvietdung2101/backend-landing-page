package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import com.sopen.landingpageviettel.demo.service.HeroBrandingService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/hero-branding-section/")
public class HeroBrandingController extends GeneralController<HeroBranding> {
    @Autowired
    HeroBrandingService heroBrandingService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return heroBrandingService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody HeroBranding heroBranding) {
        return heroBrandingService.create(heroBranding);
    }
}
