package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class AboutExpand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String icon;

    @NotEmpty
    private String title;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "about_section_id")
    private AboutSection aboutSection;
}
