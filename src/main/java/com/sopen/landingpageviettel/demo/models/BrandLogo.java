package com.sopen.landingpageviettel.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BrandLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logo;

    private String logoHover;

    private String alt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "partner_client_section_id")
    private PartnerClientSection partnerClientSection;
}
