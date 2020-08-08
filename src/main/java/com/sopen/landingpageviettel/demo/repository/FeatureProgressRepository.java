package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FeatureProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureProgressRepository extends JpaRepository<FeatureProgress, Long> {
}
