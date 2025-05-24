package com.example.InternProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InternProject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
