package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class BusinessSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String section_title;
    private String video_url;
    private String video_title;

    @OneToMany
    private List<BusinessFeature> businessFeatureList;
}
