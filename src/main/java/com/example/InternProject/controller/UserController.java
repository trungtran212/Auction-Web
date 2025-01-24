package com.example.InternProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.entity.UserEntity;
import com.example.InternProject.model.Users;
import com.example.InternProject.service.interfaces.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) throws Exception {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/users/AllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers() throws Exception {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/users/{ID}")
    public ResponseEntity<Boolean> deleteUserById() throws Exception {
        
    }
}
