package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    Style findTopByOrderByIdDesc();
}
