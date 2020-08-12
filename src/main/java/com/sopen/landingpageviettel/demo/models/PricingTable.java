package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class PricingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(columnDefinition = "text")
    private String thumb;

    @NotEmpty
    private String title;

    @NotEmpty
    private String value;

    @NotEmpty
    private String alt;

    @NotEmpty
    private String duration;

    private Boolean isPopular;

    private Boolean active;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pricing_component_id")
    private PricingComponent pricingComponent;

    @NotEmpty
    @ElementCollection
    private List<String> price;
}
