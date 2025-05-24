package com.example.InternProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private Double startingPrice;

    private String imageUrl; // lưu link hoặc tên ảnh

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
