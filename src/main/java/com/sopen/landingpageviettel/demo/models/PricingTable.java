package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.List;

@Entity
@Data
public class PricingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thumb;

    private String title;

    private String value;

    private String alt;

    private Boolean isPopular;

    private Boolean active;

    @ElementCollection
    private List<String> price;
}
