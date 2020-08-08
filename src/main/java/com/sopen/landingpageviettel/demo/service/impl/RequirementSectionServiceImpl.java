package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import com.sopen.landingpageviettel.demo.repository.RequirementSectionRepository;
import com.sopen.landingpageviettel.demo.service.RequirementSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementSectionServiceImpl implements RequirementSectionService {
    @Autowired
    RequirementSectionRepository requirementSectionRepository;

    @Override
    public List<RequirementSection> getAll() {
        return requirementSectionRepository.findAll();
    }

    @Override
    public RequirementSection getLatest() {
        return requirementSectionRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(RequirementSection requirementSection) {
        requirementSectionRepository.save(requirementSection);
    }
}
