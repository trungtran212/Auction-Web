package com.example.InternProject.model;

import com.example.InternProject.entity.ProductEntity;
import com.example.InternProject.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bids {
    private Long bidID;
    private Double amount;
    private UserEntity user;
    private ProductEntity product;
}
