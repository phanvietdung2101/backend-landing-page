package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class BrandLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Image logo;

    @NotNull
    @ManyToOne
    private Image logoHover;

    @NotEmpty
    private String alt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "partner_client_section_id")
    private PartnerClientSection partnerClientSection;
}
