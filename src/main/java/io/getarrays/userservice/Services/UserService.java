package io.getarrays.userservice.Services;

import java.util.List;

import io.getarrays.userservice.Domains.Role;
import io.getarrays.userservice.Domains.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
