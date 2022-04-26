package io.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    
}
