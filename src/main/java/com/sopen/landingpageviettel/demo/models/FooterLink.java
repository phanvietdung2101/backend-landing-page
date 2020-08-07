package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FooterLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String href;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "footer_section_id")
    private FooterSection footerSection;
}
