package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.LandingPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandingPageRepository extends JpaRepository<LandingPage, Long> {
    LandingPage findTopByOrderByIdDesc();
}
