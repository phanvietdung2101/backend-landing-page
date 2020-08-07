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

    @Autowired
    FeatureCarouselSectionRepository featureCarouselSectionRepository;

    @Autowired
    FeatureCarouselRepository featureCarouselRepository;

    @Autowired
    ProgressCircleRepository progressCircleRepository;

    @Autowired
    FeatureProgressRepository featureProgressRepository;

    @Autowired
    PricingComponentRepository pricingComponentRepository;

    @Autowired
    PricingTableRepository pricingTableRepository;

    @Autowired
    PartnerClientSectionRepository partnerClientSectionRepository;

    @Autowired
    BrandLogoRepository brandLogoRepository;

    @Autowired
    NewsletterSectionRepository newsletterSectionRepository;

    @Autowired
    FooterSectionRepository footerSectionRepository;

    @Autowired
    FooterLinkRepository footerLinkRepository;

    @Autowired
    SearchBoxRepository searchBoxRepository;

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
        // save requirement section
        requirementSectionRepository.save(landingPage.getRequirementSection());
        // save feature carousel section
        featureCarouselSectionRepository.save(landingPage.getFeatureCarouselSection());
        List<FeatureCarousel> featureCarouselList = landingPage.getFeatureCarouselSection().getFeatureCarouselList();
        featureCarouselList.forEach(featureCarousel -> {
            featureCarousel.setFeatureCarouselSection(landingPage.getFeatureCarouselSection());
            // save feature carousel
            featureCarouselRepository.save(featureCarousel);
        });
        // save circle progress
        progressCircleRepository.save(landingPage.getProgressCircle());
        List<FeatureProgress> featureProgressList = landingPage.getProgressCircle().getFeatureProgressList();
        featureProgressList.forEach(featureProgress -> {
            featureProgress.setProgressCircle(landingPage.getProgressCircle());
            // save feature progress
            featureProgressRepository.save(featureProgress);
        });
        // save pricing component
        pricingComponentRepository.save(landingPage.getPricingComponent());
        List<PricingTable> pricingTableList = landingPage.getPricingComponent().getPricingTableList();
        pricingTableList.forEach(pricingTable -> {
            pricingTable.setPricingComponent(landingPage.getPricingComponent());
            // save pricing table
            pricingTableRepository.save(pricingTable);
        });
        // save partner section
        partnerClientSectionRepository.save(landingPage.getPartnerClientSection());
        List<BrandLogo> brandLogoList = landingPage.getPartnerClientSection().getBrandLogoList();
        brandLogoList.forEach(brandLogo -> {
            brandLogo.setPartnerClientSection(landingPage.getPartnerClientSection());
            // save brand logo
            brandLogoRepository.save(brandLogo);
        });
        // save new letter
        newsletterSectionRepository.save(landingPage.getNewsletterSection());
        // save footer section
        footerSectionRepository.save(landingPage.getFooterSection());
        List<FooterLink> footerLinkList = landingPage.getFooterSection().getFooterLinkList();
        footerLinkList.forEach(footerLink -> {
            footerLink.setFooterSection(landingPage.getFooterSection());
            // save footer link
            footerLinkRepository.save(footerLink);
        });
        // save searchBox
        searchBoxRepository.save(landingPage.getSearchBox());
        // save landingPage
        return landingPageRepository.save(landingPage);
    }

    @Override
    public LandingPage getLatest() {
        return landingPageRepository.findTopByOrderByIdDesc();
    }
}
