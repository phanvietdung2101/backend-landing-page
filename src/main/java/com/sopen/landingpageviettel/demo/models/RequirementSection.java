package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class RequirementSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    @OneToOne
    private Image image;

    @NotEmpty
    private String button_title;

    @NotEmpty
    private String button_href;

    @NotEmpty
    @ElementCollection
    private List<String> requirementList;

    private Boolean showSection;

    private String title_style;

    private String description_style;

    private String image_style;

    private String button_style;

    private String text_style;
}
