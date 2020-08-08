package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.PricingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingTableRepository extends JpaRepository<PricingTable, Long> {
}
