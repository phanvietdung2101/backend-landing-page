package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import com.sopen.landingpageviettel.demo.repository.RequirementSectionRepository;
import com.sopen.landingpageviettel.demo.service.RequirementSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class RequirementSectionServiceImpl implements RequirementSectionService {
    @Autowired
    RequirementSectionRepository requirementSectionRepository;

    @Override
    public ServiceResult getLatest() {
        RequirementSection requirementSection = requirementSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(requirementSection, "ok");
    }

    @Override
    public ServiceResult save(RequirementSection requirementSection) {
        try {
            if (requirementSection.getId() != null){
                long id = requirementSection.getId();
                requirementSection.setId(null);
                requirementSectionRepository.deleteById(id);
            }
            requirementSection = requirementSectionRepository.save(requirementSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(requirementSection, "ok");
    }
}
