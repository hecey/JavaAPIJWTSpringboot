package io.getarrays.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.Domains.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    
}
