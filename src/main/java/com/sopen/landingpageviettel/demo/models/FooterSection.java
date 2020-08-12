package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class FooterSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String logo_src;

    @NotEmpty
    private String title;

    @NotEmpty
    @OneToMany(mappedBy = "footerSection")
    private List<FooterLink> footerLinkList;
}
