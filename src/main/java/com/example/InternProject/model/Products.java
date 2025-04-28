package com.example.InternProject.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private Long productID;
    private String productName;
    private Double productPrice;
    private String productDesc;
    private String imageURL;
    private Long timeRemaining;
    private LocalDateTime createAt;
    private LocalDateTime endAt;
}
