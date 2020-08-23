package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class PricingComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String popularTitle;

    @NotEmpty
    @OneToMany(mappedBy = "pricingComponent", orphanRemoval = true)
    private List<PricingTable> pricingTableList;
}
