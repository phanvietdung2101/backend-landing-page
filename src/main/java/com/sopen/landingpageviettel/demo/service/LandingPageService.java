package com.sopen.landingpageviettel.demo.service;

import com.sopen.landingpageviettel.demo.models.LandingPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LandingPageService {
    List<LandingPage> findAll();
    LandingPage create(LandingPage landingPage);
    LandingPage getLatest();
}
