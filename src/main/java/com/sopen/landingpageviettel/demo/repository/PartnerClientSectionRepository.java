package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.PartnerClientSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerClientSectionRepository extends JpaRepository<PartnerClientSection, Long> {
}
