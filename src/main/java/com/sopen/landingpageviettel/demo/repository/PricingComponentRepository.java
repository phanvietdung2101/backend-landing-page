package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.PricingComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingComponentRepository extends JpaRepository<PricingComponent, Long> {
}
