package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import com.sopen.landingpageviettel.demo.service.RequirementSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/requirement-section/")
public class RequirementSectionController extends GeneralController<RequirementSection> {
    @Autowired
    RequirementSectionService requirementSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return requirementSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody RequirementSection requirementSection) {
        return requirementSectionService.save(requirementSection);
    }
}
