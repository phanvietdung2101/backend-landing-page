package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class ProgressCircle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToMany(mappedBy = "progressCircle")
    private List<FeatureProgress> featureProgressList;

    private Boolean showSection;

    private String progress_style;

    private String title_style;

    private String list_text_style;
}
