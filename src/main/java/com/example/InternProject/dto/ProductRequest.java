package com.example.InternProject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double startingPrice;
    private String imageUrl;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}