package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class PricingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Image image;

    @NotEmpty
    private String title;

    @NotEmpty
    private String value;

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
