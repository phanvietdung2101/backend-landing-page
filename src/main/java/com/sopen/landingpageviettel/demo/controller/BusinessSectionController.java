package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.BusinessSection;
import com.sopen.landingpageviettel.demo.service.BusinessSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/business-section/")
public class BusinessSectionController extends GeneralController<BusinessSection> {
    @Autowired
    BusinessSectionService businessSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return businessSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(BusinessSection businessSection) {
        return businessSectionService.create(businessSection);
    }
}
