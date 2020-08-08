package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BusinessFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessFeatureRepository extends JpaRepository<BusinessFeature, Long> {
}
