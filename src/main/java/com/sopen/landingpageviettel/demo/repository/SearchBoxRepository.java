package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.SearchBox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchBoxRepository extends CrudRepository<SearchBox, Long> {
}
