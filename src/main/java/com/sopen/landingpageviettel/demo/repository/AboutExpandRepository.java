package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.AboutExpand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutExpandRepository extends CrudRepository<AboutExpand,Long> {
}
