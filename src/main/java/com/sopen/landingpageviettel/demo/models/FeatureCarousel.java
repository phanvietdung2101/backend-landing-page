package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FeatureCarousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String image_url;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "feature_carousel_section_id")
    private FeatureCarouselSection featureCarouselSection;
}
