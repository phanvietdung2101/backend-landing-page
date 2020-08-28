package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class AboutSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @NotEmpty
    @OneToMany(mappedBy = "aboutSection")
    private List<AboutExpand> aboutExpandList;

    private Boolean showSection;

    private String title_style;

    private String text_style;

    private String title_expand_style;

    private String image_expand_style;
}
