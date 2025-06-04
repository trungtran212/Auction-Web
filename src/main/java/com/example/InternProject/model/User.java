package com.example.InternProject.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role; // Giả sử Role là String, nếu là Enum thì cần điều chỉnh

    private String address;

    private String phone;

    private BigDecimal balance = BigDecimal.ZERO; // Số dư tài khoản, mặc định là 0

    @OneToMany(mappedBy = "user")
    private List<Bid> bids; // Danh sách các bid của người dùng

    // Các trường khác nếu cần thiết
    private List<Product> wonProducts = new ArrayList<>();
}
