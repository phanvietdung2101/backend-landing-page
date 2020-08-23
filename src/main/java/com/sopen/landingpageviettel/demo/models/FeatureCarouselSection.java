package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class FeatureCarouselSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToMany(mappedBy = "featureCarouselSection", orphanRemoval = true)
    private List<FeatureCarousel> featureCarouselList;
}
