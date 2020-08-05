package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class BusinessFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String icon;
    private String title;
    private String desc;
}
