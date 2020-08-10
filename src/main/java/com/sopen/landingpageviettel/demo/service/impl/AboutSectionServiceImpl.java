package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.AboutExpand;
import com.sopen.landingpageviettel.demo.models.AboutSection;
import com.sopen.landingpageviettel.demo.repository.AboutExpandRepository;
import com.sopen.landingpageviettel.demo.repository.AboutSectionRepository;
import com.sopen.landingpageviettel.demo.service.AboutSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServiceResult create(AboutSection aboutSection) {
        aboutSection = aboutSectionRepository.save(aboutSection);
        // set aboutSection for aboutExpand list
        List<AboutExpand> aboutExpandList = aboutSection.getAboutExpandList();
        for (AboutExpand aboutExpand : aboutExpandList) {
            aboutExpand.setAboutSection(aboutSection);
            // save aboutExpand
            aboutExpandRepository.save(aboutExpand);
        }
        return new ServiceResult(aboutSection,"ok");
    }
}
