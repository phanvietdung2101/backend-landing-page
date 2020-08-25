package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class NewsletterSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String button_title;

    @NotEmpty
    private String button_href;

    @NotEmpty
    private String description;

    @NotEmpty
    private String description_button_title;

    @NotEmpty
    private String description_button_href;

    @NotEmpty
    private String style;
}
