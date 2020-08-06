package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.ProgressCircle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressCircleRepository extends CrudRepository<ProgressCircle, Long> {
}
