package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.NewsletterSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterSectionRepository extends CrudRepository<NewsletterSection, Long> {
}
