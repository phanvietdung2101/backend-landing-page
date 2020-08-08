package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FooterLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterLinkRepository extends JpaRepository<FooterLink, Long> {
}
