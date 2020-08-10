package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.FooterSection;
import com.sopen.landingpageviettel.demo.service.FooterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/footer-section/")
public class FooterSectionController extends GeneralController<FooterSection> {
    @Autowired
    FooterSectionService footerSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return footerSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody FooterSection footerSection) {
        return footerSectionService.create(footerSection);
    }
}
