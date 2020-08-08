package com.sopen.landingpageviettel.demo.service;

import com.sopen.landingpageviettel.demo.models.LandingPage;

public interface LandingPageService extends GeneralService<LandingPage>{
    LandingPage create(LandingPage landingPage);
}
