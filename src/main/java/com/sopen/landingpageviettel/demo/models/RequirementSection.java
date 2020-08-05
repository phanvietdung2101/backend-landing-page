package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RequirementSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String desc;

    @ElementCollection
    private List<String> requirementList;
}
