package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.HeroBranding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroBrandingRepository extends CrudRepository<HeroBranding, Long> {
}
