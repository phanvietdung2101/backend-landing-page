package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "`business_feature`")
public class BusinessFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String title;
    private String description;
}
