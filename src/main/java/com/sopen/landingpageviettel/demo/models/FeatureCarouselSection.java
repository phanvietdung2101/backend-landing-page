package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class FeatureCarouselSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<FeatureCarousel> featureCarouselList;
}
