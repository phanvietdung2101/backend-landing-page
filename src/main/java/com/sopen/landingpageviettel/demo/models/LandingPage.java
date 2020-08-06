package com.sopen.landingpageviettel.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LandingPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Navbar navbar;

}
