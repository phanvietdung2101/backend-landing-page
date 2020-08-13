package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class BusinessFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Image icon;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "business_section_id")
    private BusinessSection businessSection;
}
