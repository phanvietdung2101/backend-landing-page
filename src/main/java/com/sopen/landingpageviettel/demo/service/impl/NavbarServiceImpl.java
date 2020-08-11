package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Navbar;
import com.sopen.landingpageviettel.demo.repository.NavbarRepository;
import com.sopen.landingpageviettel.demo.service.NavbarService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NavbarServiceImpl implements NavbarService {
    @Autowired
    NavbarRepository navbarRepository;

    @Override
    public ServiceResult getLatest() {
        Navbar navbar = navbarRepository.findTopByOrderByIdDesc();
        return new ServiceResult(navbar,"ok");
    }

    @Override
    public ServiceResult save(Navbar navbar) {
        navbar = navbarRepository.save(navbar);
        return new ServiceResult(navbar,"ok");
    }
}
