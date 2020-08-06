package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.RequirementSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementSectionRepository extends CrudRepository<RequirementSection, Long> {
}
