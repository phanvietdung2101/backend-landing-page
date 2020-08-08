package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.SearchBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchBoxRepository extends JpaRepository<SearchBox, Long> {
    SearchBox findTopByOrderByIdDesc();
}
