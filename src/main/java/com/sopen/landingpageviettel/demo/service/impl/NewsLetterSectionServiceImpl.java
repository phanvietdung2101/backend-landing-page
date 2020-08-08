package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import com.sopen.landingpageviettel.demo.repository.NewsletterSectionRepository;
import com.sopen.landingpageviettel.demo.service.NewsLetterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterSectionServiceImpl implements NewsLetterSectionService {
    @Autowired
    NewsletterSectionRepository newsletterSectionRepository;

    @Override
    public ServiceResult getLatest() {
        NewsletterSection newsletterSection = newsletterSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(newsletterSection,"ok");
    }

    @Override
    public ServiceResult create(NewsletterSection newsletterSection) {
        newsletterSectionRepository.save(newsletterSection);
        return new ServiceResult("ok");
    }
}
