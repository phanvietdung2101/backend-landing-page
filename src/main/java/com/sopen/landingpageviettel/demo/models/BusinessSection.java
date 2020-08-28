package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class BusinessSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String section_title;

    @NotEmpty
    private String video_url;

    @NotEmpty
    private String video_title;

    @NotNull
    @OneToOne
    private Image image;

    @NotEmpty
    @OneToMany(mappedBy = "businessSection")
    private List<BusinessFeature> businessFeatureList;

    private Boolean showSection;

    private String section_title_style;

    private String video_title_style;

    private String image_style;

    private String feature_title_Style;

    private String feature_description_style;

    private String feature_image_style;
}
