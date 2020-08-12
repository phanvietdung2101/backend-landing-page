package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.AboutExpand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutExpandRepository extends JpaRepository<AboutExpand, Long> {
}
