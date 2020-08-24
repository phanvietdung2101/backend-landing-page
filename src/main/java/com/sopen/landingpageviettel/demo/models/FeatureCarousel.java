package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class FeatureCarousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    @ManyToOne
    private Image image;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "feature_carousel_section_id")
    private FeatureCarouselSection featureCarouselSection;
}
