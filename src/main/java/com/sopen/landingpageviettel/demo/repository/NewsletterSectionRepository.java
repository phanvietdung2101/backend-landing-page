package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterSectionRepository extends JpaRepository<NewsletterSection, Long> {
    NewsletterSection findTopByOrderByIdDesc();
}
