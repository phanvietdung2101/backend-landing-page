package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BusinessSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessSectionRepository extends CrudRepository<BusinessSection, Long> {
}
