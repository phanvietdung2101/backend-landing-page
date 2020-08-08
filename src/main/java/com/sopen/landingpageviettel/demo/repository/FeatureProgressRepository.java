package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FeatureProgress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureProgressRepository extends CrudRepository<FeatureProgress, Long> {
}
