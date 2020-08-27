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
    @OneToMany(mappedBy = "pricingComponent")
    private List<PricingTable> pricingTableList;

    private Boolean showSection;

    private String title_style;

    private String description_style;

    private String pricing_stable_style;

    private String table_title_style;

    private String image_style;

    private String price_style;

    private String value_style;

    private String button_style;
}
