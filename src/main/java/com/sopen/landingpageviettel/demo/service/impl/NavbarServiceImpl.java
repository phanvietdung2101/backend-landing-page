package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.Navbar;
import com.sopen.landingpageviettel.demo.repository.NavbarRepository;
import com.sopen.landingpageviettel.demo.service.NavbarService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;


@Service
public class NavbarServiceImpl implements NavbarService {
    @Autowired
    NavbarRepository navbarRepository;

    @Override
    public ServiceResult getLatest() {
        Navbar navbar = navbarRepository.findTopByOrderByIdDesc();
        return new ServiceResult(navbar, "ok");
    }

    @Override
    public ServiceResult save(Navbar navbar) {
        try {
            if( navbar.getId() != null) {
                long id = navbar.getId();
                navbar.setId(null);
                navbarRepository.deleteById(id);
            }
            navbar = navbarRepository.save(navbar);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(navbar, "ok");
    }
}
