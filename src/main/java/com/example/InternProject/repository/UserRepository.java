package com.example.InternProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InternProject.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
