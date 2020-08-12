package com.sopen.landingpageviettel.demo.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
}
