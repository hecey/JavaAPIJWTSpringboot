package io.getarrays.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.Domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String rolename);
}
