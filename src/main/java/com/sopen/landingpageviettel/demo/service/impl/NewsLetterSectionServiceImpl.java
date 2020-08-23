package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import com.sopen.landingpageviettel.demo.repository.NewsletterSectionRepository;
import com.sopen.landingpageviettel.demo.service.NewsLetterSectionService;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class NewsLetterSectionServiceImpl implements NewsLetterSectionService {
    @Autowired
    NewsletterSectionRepository newsletterSectionRepository;

    @Override
    public ServiceResult getLatest() {
        NewsletterSection newsletterSection = newsletterSectionRepository.findTopByOrderByIdDesc();
        return new ServiceResult(newsletterSection, "ok");
    }

    @Override
    public ServiceResult save(NewsletterSection newsletterSection) {
        try {
            if (newsletterSection.getId() != null) {
                long id = newsletterSection.getId();
                newsletterSection.setId(null);
                newsletterSectionRepository.deleteById(id);
            }
            newsletterSection = newsletterSectionRepository.save(newsletterSection);
        } catch (ConstraintViolationException e) {
            return new ServiceResult(e.getCause(), "object field must be not null or empty");
        }
        return new ServiceResult(newsletterSection, "ok");
    }
}
