package com.example.InternProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.InternProject.dto.ProductRequest;
import com.example.InternProject.dto.ProductResponse;
import com.example.InternProject.exception.CustomException;
import com.example.InternProject.model.Product;
import com.example.InternProject.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStartingPrice(request.getStartingPrice());
        product.setImageUrl(request.getImageUrl());
        product.setStartTime(request.getStartTime());
        product.setEndTime(request.getEndTime());

        Product saved = productRepository.save(product);
        return mapToResponse(saved);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Sản phẩm không tồn tại với id: " + id));
        return mapToResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Sản phẩm không tồn tại với id: " + id));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setStartingPrice(request.getStartingPrice());
        product.setImageUrl(request.getImageUrl());
        product.setStartTime(request.getStartTime());
        product.setEndTime(request.getEndTime());

        Product updated = productRepository.save(product);
        return mapToResponse(updated);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Sản phẩm không tồn tại với id: " + id));
        productRepository.delete(product);
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStartingPrice(),
                product.getImageUrl(),
                product.getStartTime(),
                product.getEndTime());
    }
}