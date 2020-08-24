package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.Navbar;
import com.sopen.landingpageviettel.demo.service.NavbarService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/navbar-section/")
public class NavbarController extends GeneralController<Navbar>{
    @Autowired
    NavbarService navbarService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return navbarService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(@RequestBody Navbar navbar) {
        return navbarService.save(navbar);
    }
}
