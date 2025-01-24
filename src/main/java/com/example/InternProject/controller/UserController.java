package com.example.InternProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.entity.UserEntity;
import com.example.InternProject.model.Users;
import com.example.InternProject.service.interfaces.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/users/{ID}")
    public ResponseEntity<UserEntity> getUserByID(@PathVariable("ID") Long ID) throws Exception {
        return ResponseEntity.ok(userService.getUserByID(ID));
    }

    @GetMapping("/users/find")
    public ResponseEntity<List<UserEntity>> getUserByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @DeleteMapping("/users/{ID}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("ID") Long ID) throws Exception {
        return ResponseEntity.ok(userService.deleteUserByID(ID));
    }

    @PatchMapping("/users/{ID}")
    public ResponseEntity<Users> updateUser(@PathVariable("ID") Long ID, @RequestBody Users user) throws Exception {
        return ResponseEntity.ok(userService.updateUser(ID, user));
    }
}
