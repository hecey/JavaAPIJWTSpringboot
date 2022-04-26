package io.getarrays.userservice.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repository.RoleRepository;
import io.getarrays.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService{
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        if(user==null){
            log.info("User not found in the database");
            throw new UsernameNotFoundException("User not found in database");
        }else{
            log.info("User found in the database", user);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->{
         authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByName(roleName);
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    
}
