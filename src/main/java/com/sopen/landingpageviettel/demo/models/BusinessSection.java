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

    private String style;
}
