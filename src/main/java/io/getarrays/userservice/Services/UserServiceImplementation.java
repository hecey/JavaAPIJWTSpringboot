package io.getarrays.userservice.Services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.getarrays.userservice.Domains.Role;
import io.getarrays.userservice.Domains.User;
import io.getarrays.userservice.repositories.RoleRepository;
import io.getarrays.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void addRoleToUser(String userName, String roleName) {
        
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByRole(roleName);
        log.info("Adding a role {} to an user {}",userName , roleName);
        user.getRoles().add(role);
        
    }

    @Override
    public List<User> getUsers() {
        log.info("Fecthing all users");
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userName) {
        log.info("Fecthing an user {}", userName);
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving a new role {}", role);
        return roleRepository.save(role);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving a new user {}", user);        
        return userRepository.save(user);
    }
}
