package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.PartnerClientSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerClientSectionRepository extends CrudRepository<PartnerClientSection, Long> {
}
