package io.getarrays.userservice.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.getarrays.userservice.Domains.User;
import io.getarrays.userservice.Services.UserService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor 
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
