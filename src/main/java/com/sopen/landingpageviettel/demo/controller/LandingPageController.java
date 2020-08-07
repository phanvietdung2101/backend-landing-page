package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.LandingPage;
import com.sopen.landingpageviettel.demo.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LandingPageController {
    @Autowired
    LandingPageService landingPageService;

    @PostMapping("/create")
    public ResponseEntity<Void> createLandingPageContent(@RequestBody LandingPage landingPage){
        landingPageService.create(landingPage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<LandingPage> findAll(){
        return landingPageService.findAll();
    }
}
