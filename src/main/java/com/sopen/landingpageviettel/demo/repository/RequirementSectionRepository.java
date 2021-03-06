package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementSectionRepository extends JpaRepository<RequirementSection, Long> {
    RequirementSection findTopByOrderByIdDesc();
}
