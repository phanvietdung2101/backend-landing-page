package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Navbar;
import com.sopen.landingpageviettel.demo.repository.NavbarRepository;
import com.sopen.landingpageviettel.demo.service.NavbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavbarServiceImpl implements NavbarService {
    @Autowired
    NavbarRepository navbarRepository;

    @Override
    public List<Navbar> getAll() {
        return navbarRepository.findAll();
    }

    @Override
    public Navbar getLatest() {
        return navbarRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(Navbar navbar) {
        navbarRepository.save(navbar);
    }
}
