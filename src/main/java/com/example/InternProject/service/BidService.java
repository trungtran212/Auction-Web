package com.example.InternProject.service;

import org.springframework.stereotype.Service;

import com.example.InternProject.model.Bid;
import com.example.InternProject.model.Product;
import com.example.InternProject.model.User;
import com.example.InternProject.repository.BidRepository;
import com.example.InternProject.repository.ProductRepository;
import com.example.InternProject.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BidService {
    private final BidRepository bidRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public BidService(BidRepository bidRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Bid placeBid(String username, Long productId, double amount) {
        User user = userRepository.findByUsername(username).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        if (product.isFinished()) {
            throw new IllegalStateException("Phiên đấu giá đã kết thúc");
        }

        if (user.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new IllegalArgumentException("Số dư không đủ");
        }

        Bid bid = new Bid();
        bid.setUser(user);
        bid.setProduct(product);
        bid.setAmount(BigDecimal.valueOf(amount));
        bid.setTimestamp(LocalDateTime.now());
        return bidRepository.save(bid);
    }

    public List<Bid> getUserBidHistory(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return bidRepository.findByUser(user);
    }

    public List<Bid> getProductBids(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return bidRepository.findByProduct(product);
    }
}