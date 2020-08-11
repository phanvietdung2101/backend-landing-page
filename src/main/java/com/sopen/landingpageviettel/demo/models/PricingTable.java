package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(columnDefinition = "text")
    private String thumb;

    private String title;

    private String value;

    private String alt;

    private Boolean isPopular;

    private Boolean active;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pricing_component_id")
    private PricingComponent pricingComponent;

    @ElementCollection
    private List<String> price;
}
