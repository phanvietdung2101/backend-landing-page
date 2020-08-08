package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import com.sopen.landingpageviettel.demo.repository.RequirementSectionRepository;
import com.sopen.landingpageviettel.demo.service.RequirementSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementSectionServiceImpl implements RequirementSectionService {
    @Autowired
    RequirementSectionRepository requirementSectionRepository;

    @Override
    public ServiceResult getLatest() {
        RequirementSection requirementSection = requirementSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(requirementSection,"ok");
    }

    @Override
    public ServiceResult create(RequirementSection requirementSection) {
        requirementSectionRepository.save(requirementSection);
        return new ServiceResult("ok");
    }
}
