package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BusinessFeature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessFeatureRepository extends CrudRepository<BusinessFeature, Long> {
}
