package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String image_url;

    @NotEmpty
    private String button_title;

    @NotEmpty
    private String button_href;

    @NotEmpty
    @ElementCollection
    private List<String> requirementList;
}
