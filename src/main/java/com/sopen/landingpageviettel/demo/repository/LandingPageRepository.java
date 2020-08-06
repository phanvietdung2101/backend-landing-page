package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.LandingPage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandingPageRepository extends CrudRepository<LandingPage, Long> {
}
