package com.example.InternProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.model.Users;
import com.example.InternProject.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<Boolean> createUser(@RequestBody Users user) throws Exception {
        return ResponseEntity.ok(userService.createUsers(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/users/{ID}")
    public ResponseEntity<String> deleteUser(@PathVariable("ID") Long ID) throws Exception {
        Boolean deleted = userService.deleteUser(ID);
        if (deleted == false)
            return ResponseEntity.ok("User not exist");
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/users/{ID}")
    public ResponseEntity<Users> getUserInfo(@PathVariable("ID") Long ID) throws Exception {
        return ResponseEntity.ok(userService.getUserByID(ID));
    }

    @PostMapping("/users/{ID}")
    public ResponseEntity<Boolean> updateBalance(@PathVariable("ID") Long ID, @RequestBody Double balance)
            throws Exception {
        return ResponseEntity.ok(userService.updateBalance(ID, balance));
    }
}
