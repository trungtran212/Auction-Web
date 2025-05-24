package com.example.InternProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double startingPrice;
    private String imageUrl;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
