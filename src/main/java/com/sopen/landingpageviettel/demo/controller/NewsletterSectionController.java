package com.sopen.landingpageviettel.demo.controller;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import com.sopen.landingpageviettel.demo.service.NewsLetterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/newsletter-section/")
public class NewsletterSectionController extends GeneralController<NewsletterSection> {
    @Autowired
    NewsLetterSectionService newsLetterSectionService;

    @GetMapping("get-latest")
    @Override
    public ServiceResult getLatest() {
        return newsLetterSectionService.getLatest();
    }

    @PostMapping("create")
    @Override
    public ServiceResult create(NewsletterSection newsletterSection) {
        return newsLetterSectionService.create(newsletterSection);
    }
}
