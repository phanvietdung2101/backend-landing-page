package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class PartnerClientSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @NotEmpty
    @OneToMany(mappedBy = "partnerClientSection", orphanRemoval = true)
    private List<BrandLogo> brandLogoList;
}
