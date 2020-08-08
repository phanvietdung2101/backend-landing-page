package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FooterSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logoSrc;

    private String title;

    @OneToMany(mappedBy = "footerSection")
    private List<FooterLink> footerLinkList;
}
