package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class BusinessFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "business_section_id")
    private BusinessSection businessSection;
}
