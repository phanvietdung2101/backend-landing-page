package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.PricingTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingTableRepository extends CrudRepository<PricingTable, Long> {
}
