package com.sopen.landingpageviettel.demo.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class NewsletterSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String buttonTitle;

    private String text;

    private String textTitle;

    private String textHref;
}
