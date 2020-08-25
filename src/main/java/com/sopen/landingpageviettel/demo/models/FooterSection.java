package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class FooterSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Image image;

    @NotEmpty
    private String title;

    @NotEmpty
    @OneToMany(mappedBy = "footerSection")
    private List<FooterLink> footerLinkList;
}
