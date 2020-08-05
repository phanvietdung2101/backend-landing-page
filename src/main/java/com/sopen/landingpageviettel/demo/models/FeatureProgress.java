package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class FeatureProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String progress;

    private String featureListTitle;

    @ElementCollection
    private List<String> featureList;
}
