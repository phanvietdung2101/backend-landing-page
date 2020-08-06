package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AboutExpand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private String title;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "about_section_id")
    private AboutSection aboutSection;
}
