package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BrandLogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandLogoRepository extends CrudRepository<BrandLogo, Long> {
}
