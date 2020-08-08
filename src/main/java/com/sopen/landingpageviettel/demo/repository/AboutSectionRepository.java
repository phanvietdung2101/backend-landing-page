package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.AboutSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutSectionRepository extends JpaRepository<AboutSection, Long> {
}
