package com.example.InternProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private BigDecimal startingPrice;

    private LocalDateTime createdAt;
    private Long duration;

    private String imageUrl;

    private boolean finished = false;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Bid> bids; // Danh sách các bid của sản phẩm
}
