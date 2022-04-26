package io.getarrays.userservice.service;

import java.util.List;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
