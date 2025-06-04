package com.example.InternProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.model.Bid;
import com.example.InternProject.model.Product;
import com.example.InternProject.service.BidService;
import com.example.InternProject.service.ProductService;
import com.example.InternProject.service.UserService;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {
    private final UserService userService;
    private final BidService bidService;
    private final ProductService productService;

    public UserController(UserService userService, BidService bidService, ProductService productService) {
        this.userService = userService;
        this.bidService = bidService;
        this.productService = productService;
    }

    @PostMapping("/recharge")
    public ResponseEntity<String> recharge(@RequestParam double amount, Principal principal) {
        userService.recharge(principal.getName(), java.math.BigDecimal.valueOf(amount));
        if (amount <= 0) {
            return ResponseEntity.badRequest().body("Số tiền nạp phải lớn hơn 0");
        }
        return ResponseEntity.ok("Nạp thành công");
    }

    @GetMapping("/bid-history")
    public ResponseEntity<List<Bid>> bidHistory(Principal principal) {
        return ResponseEntity.ok(bidService.getUserBidHistory(principal.getName()));
    }

    @GetMapping("/won-products")
    public ResponseEntity<List<Product>> wonProducts(Principal principal) {
        return ResponseEntity.ok(productService.getUserWonProducts(principal.getName()));
    }
}