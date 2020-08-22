package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.AboutExpand;
import com.sopen.landingpageviettel.demo.models.AboutSection;
import com.sopen.landingpageviettel.demo.repository.AboutExpandRepository;
import com.sopen.landingpageviettel.demo.repository.AboutSectionRepository;
import com.sopen.landingpageviettel.demo.service.AboutSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class AboutSectionServiceImpl implements AboutSectionService {
    @Autowired
    AboutSectionRepository aboutSectionRepository;

    @Autowired
    AboutExpandRepository aboutExpandRepository;


    @Override
    public ServiceResult getLatest() {
        AboutSection aboutSection = aboutSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(aboutSection, "ok");
    }

    @Override
    public ServiceResult save(AboutSection aboutSection) {
        try {
            aboutSection = saveAboutSectionTransaction(aboutSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(aboutSection, "ok");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW
            , rollbackFor = ConstraintViolationException.class)
    AboutSection saveAboutSectionTransaction(AboutSection aboutSection) {
        if (aboutSection.getId() == null) {
            aboutSection = aboutSectionRepository.save(aboutSection);
        }
        List<AboutExpand> aboutExpandList = aboutSection.getAboutExpandList();
        for (AboutExpand aboutExpand : aboutExpandList) {
            aboutExpand.setAboutSection(aboutSection);
            aboutExpandRepository.save(aboutExpand);
        }
        aboutSectionRepository.save(aboutSection);
        return aboutSection;
    }
}
