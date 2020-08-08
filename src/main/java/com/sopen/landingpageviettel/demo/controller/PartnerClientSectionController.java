package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.PartnerClientSection;
import com.sopen.landingpageviettel.demo.service.PartnerClientSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/partner-client-section/")
public class PartnerClientSectionController extends GeneralController<PartnerClientSection> {
    @Autowired
    PartnerClientSectionService partnerClientSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return partnerClientSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(PartnerClientSection partnerClientSection) {
        return partnerClientSectionService.create(partnerClientSection);
    }
}
