package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class HeroBranding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String title_style;

    @NotEmpty
    private String description;

    private String description_style;

    @NotEmpty
    private String button_title;

    private String button_title_style;

    @NotEmpty
    private String button_href;

    @NotNull
    @OneToOne
    private Image image;

    private Boolean showSection;

}
