package com.example.InternProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.InternProject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.finished = true")
    List<Product> findAllFinishedProducts();

    @Query("SELECT p FROM Product p WHERE p.finished = false")
    List<Product> findAllOngoingProducts();

    List<Product> findByIsFinishedFalse();
}
