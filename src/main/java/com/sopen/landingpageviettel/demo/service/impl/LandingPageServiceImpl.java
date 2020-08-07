package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.*;
import com.sopen.landingpageviettel.demo.repository.*;
import com.sopen.landingpageviettel.demo.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandingPageServiceImpl implements LandingPageService {
    @Autowired
    LandingPageRepository landingPageRepository;

    @Autowired
    NavbarRepository navbarRepository;

    @Autowired
    HeroBrandingRepository heroBrandingRepository;

    @Autowired
    AboutSectionRepository aboutSectionRepository;

    @Autowired
    AboutExpandRepository aboutExpandRepository;

    @Autowired
    BusinessSectionRepository businessSectionRepository;

    @Autowired
    BusinessFeatureRepository businessFeatureRepository;

    @Autowired
    RequirementSectionRepository requirementSectionRepository;

    @Override
    public List<LandingPage> findAll() {
        return (List<LandingPage>) landingPageRepository.findAll();
    }


    @Override
    public LandingPage create(LandingPage landingPage) {
        // save navbar
        navbarRepository.save(landingPage.getNavbar());
        // save heroBranding
        heroBrandingRepository.save(landingPage.getHeroBranding());
        // save aboutSection
        aboutSectionRepository.save(landingPage.getAboutSection());
        // set aboutSection for aboutExpand list
        List<AboutExpand> aboutExpandList = landingPage.getAboutSection().getAboutExpandList();
        aboutExpandList.forEach(aboutExpand -> {
            aboutExpand.setAboutSection(landingPage.getAboutSection());
            // save aboutExpand
            aboutExpandRepository.save(aboutExpand);
        });
        // save business section
        businessSectionRepository.save(landingPage.getBusinessSection());
        // save business feature list
        List<BusinessFeature> businessFeatureList = landingPage.getBusinessSection().getBusinessFeatureList();
        businessFeatureList.forEach(businessFeature -> {
            businessFeature.setBusinessSection(landingPage.getBusinessSection());
            // save business feature
            businessFeatureRepository.save(businessFeature);
        });
        requirementSectionRepository.save(landingPage.getRequirementSection());

        // save landingPage
        return landingPageRepository.save(landingPage);
    }
}
