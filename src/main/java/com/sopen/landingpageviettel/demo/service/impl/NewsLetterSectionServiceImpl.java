package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import com.sopen.landingpageviettel.demo.repository.NewsletterSectionRepository;
import com.sopen.landingpageviettel.demo.service.NewsLetterSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterSectionServiceImpl implements NewsLetterSectionService {
    @Autowired
    NewsletterSectionRepository newsletterSectionRepository;

    @Override
    public List<NewsletterSection> getAll() {
        return newsletterSectionRepository.findAll();
    }

    @Override
    public NewsletterSection getLatest() {
        return newsletterSectionRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void create(NewsletterSection newsletterSection) {
        newsletterSectionRepository.save(newsletterSection);
    }
}
