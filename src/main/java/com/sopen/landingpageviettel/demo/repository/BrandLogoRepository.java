package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.BrandLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandLogoRepository extends JpaRepository<BrandLogo, Long> {
}
