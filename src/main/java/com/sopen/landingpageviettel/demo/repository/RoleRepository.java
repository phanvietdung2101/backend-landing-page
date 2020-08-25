package com.sopen.landingpageviettel.demo.repository;

import com.sopen.landingpageviettel.demo.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
