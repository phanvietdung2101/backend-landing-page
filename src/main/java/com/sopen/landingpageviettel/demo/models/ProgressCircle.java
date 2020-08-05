package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProgressCircle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<FeatureProgress> featureProgressList;
}
