package com.example.InternProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.InternProject.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT u.* FROM users u WHERE u.name LIKE %:name%", nativeQuery = true)
    List<UserEntity> findByNameContaining(@Param("name") String name);

    boolean existsByEmail(String email);
}
