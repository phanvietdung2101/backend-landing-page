package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FooterSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterSectionRepository extends JpaRepository<FooterSection, Long> {
}
