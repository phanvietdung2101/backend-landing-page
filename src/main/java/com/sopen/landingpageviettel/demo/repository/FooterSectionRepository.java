package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.FooterSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterSectionRepository extends CrudRepository<FooterSection, Long> {
}
