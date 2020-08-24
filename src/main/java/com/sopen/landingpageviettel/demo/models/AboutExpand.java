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

    @NotNull
    @ManyToOne
    private Image image;

    @NotEmpty
    private String title;

    @NotEmpty
    private String href;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "about_section_id")
    private AboutSection aboutSection;
}
