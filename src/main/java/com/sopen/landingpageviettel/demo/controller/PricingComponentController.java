package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.PricingComponent;
import com.sopen.landingpageviettel.demo.service.PricingComponentService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pricing-component-section/")
public class PricingComponentController extends GeneralController<PricingComponent> {
    @Autowired
    PricingComponentService pricingComponentService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return pricingComponentService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody PricingComponent pricingComponent) {
        return pricingComponentService.create(pricingComponent);
    }
}
