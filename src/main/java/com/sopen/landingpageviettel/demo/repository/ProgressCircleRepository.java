package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressCircleRepository extends JpaRepository<ProgressCircle, Long> {
    ProgressCircle findTopByOrderByIdDesc();
}
