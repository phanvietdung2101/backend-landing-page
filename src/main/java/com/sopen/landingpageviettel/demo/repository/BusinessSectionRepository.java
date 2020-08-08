package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BusinessSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessSectionRepository extends JpaRepository<BusinessSection, Long> {
    BusinessSection findTopByOrderByIdDesc();
}
