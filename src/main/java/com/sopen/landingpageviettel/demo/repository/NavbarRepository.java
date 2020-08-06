package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.Navbar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavbarRepository extends CrudRepository<Navbar, Long> {
}
