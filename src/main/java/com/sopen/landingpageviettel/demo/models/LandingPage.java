package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LandingPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Navbar navbar;

    @ManyToOne
    private HeroBranding heroBranding;

    @ManyToOne
    private AboutSection aboutSection;

    @ManyToOne
    private BusinessSection businessSection;

    @ManyToOne
    private RequirementSection requirementSection;

    @ManyToOne
    private FeatureCarouselSection featureCarouselSection;

    @ManyToOne
    private ProgressCircle progressCircle;

    @ManyToOne
    private PricingComponent pricingComponent;

    @ManyToOne
    private PartnerClientSection partnerClientSection;

    @ManyToOne
    private NewsletterSection newsletterSection;

    @ManyToOne
    private FooterSection footerSection;

    @ManyToOne
    private SearchBox searchBox;

}
