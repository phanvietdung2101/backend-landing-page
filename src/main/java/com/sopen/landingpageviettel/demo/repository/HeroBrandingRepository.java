package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroBrandingRepository extends JpaRepository<HeroBranding, Long> {
}
