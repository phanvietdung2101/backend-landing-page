package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.AboutExpand;
import com.sopen.landingpageviettel.demo.models.AboutSection;
import com.sopen.landingpageviettel.demo.repository.AboutExpandRepository;
import com.sopen.landingpageviettel.demo.repository.AboutSectionRepository;
import com.sopen.landingpageviettel.demo.service.AboutSectionService;
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
    public List<AboutSection> getAll() {
        return aboutSectionRepository.findAll();
    }

    @Override
    public AboutSection getLatest() {
        return aboutSectionRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(AboutSection aboutSection) {
        aboutSectionRepository.save(aboutSection);
        // set aboutSection for aboutExpand list
        List<AboutExpand> aboutExpandList = aboutSection.getAboutExpandList();
        aboutExpandList.forEach(aboutExpand -> {
            aboutExpand.setAboutSection(aboutSection);
            // save aboutExpand
            aboutExpandRepository.save(aboutExpand);
        });
    }
}
