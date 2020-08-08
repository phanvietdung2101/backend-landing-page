package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.AboutSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutSectionRepository extends CrudRepository<AboutSection, Long> {
}
