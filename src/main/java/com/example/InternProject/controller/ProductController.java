package com.example.InternProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.model.Product;
import com.example.InternProject.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/ongoing")
    public ResponseEntity<List<Product>> ongoingProducts() {
        return ResponseEntity.ok(productService.getOngoingProducts());
    }

    @GetMapping("/finished")
    public ResponseEntity<List<Product>> finishedProducts() {
        return ResponseEntity.ok(productService.getFinishedProducts());
    }
}
