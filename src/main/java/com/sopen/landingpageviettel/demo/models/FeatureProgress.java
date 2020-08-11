package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class FeatureProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long progress;

    private String featureListTitle;

    @ElementCollection
    private List<String> featureList;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "progress_circle_id")
    private ProgressCircle progressCircle;
}
