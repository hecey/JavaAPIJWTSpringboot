package io.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String rolename);
}
