package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.AboutSection;
import com.sopen.landingpageviettel.demo.service.AboutSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/about-section/")
public class AboutSectionController extends GeneralController<AboutSection> {
    @Autowired
    AboutSectionService aboutSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return aboutSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(AboutSection aboutSection) {
        return aboutSectionService.create(aboutSection);
    }
}
