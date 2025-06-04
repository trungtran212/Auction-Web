package com.example.InternProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InternProject.model.Bid;
import com.example.InternProject.model.Product;
import com.example.InternProject.model.User;
import com.example.InternProject.repository.BidRepository;
import com.example.InternProject.repository.ProductRepository;
import com.example.InternProject.repository.UserRepository;

import java.util.List;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final BidRepository bidRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, BidRepository bidRepository,
            UserRepository userRepository) {
        this.productRepository = productRepository;
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
    }

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setFinished(false);
        return productRepository.save(product);
    }

    public List<Product> getOngoingProducts() {
        return productRepository.findAllOngoingProducts();
    }

    public List<Product> getFinishedProducts() {
        return productRepository.findAllFinishedProducts();
    }

    public List<Product> getUserWonProducts(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        List<Product> finished = productRepository.findAllFinishedProducts();

        return finished.stream()
                .filter(product -> {
                    Optional<Bid> topBid = product.getBids().stream()
                            .max(Comparator.comparing(Bid::getAmount));
                    return topBid.isPresent() && topBid.get().getUser().getId().equals(user.getId());
                })
                .collect(Collectors.toList());
    }

    public void checkAndFinalizeAuctions() {
        List<Product> ongoing = productRepository.findByIsFinishedFalse();

        for (Product p : ongoing) {
            LocalDateTime endTime = p.getCreatedAt().plusSeconds(p.getDuration());
            if (LocalDateTime.now().isAfter(endTime)) {
                p.setFinished(true);

                Optional<Bid> winningBid = bidRepository.findTopByProductOrderByAmountDesc(p);
                if (winningBid.isPresent()) {
                    User winner = winningBid.get().getUser();
                    double amount = winningBid.get().getAmount();

                    if (winner.getBalance() >= amount) {
                        winner.setBalance(winner.getBalance() - amount);
                        winner.getWonProducts().add(p);

                        userRepository.save(winner);
                        System.out.println("✅ " + p.getName() + " thắng bởi " + winner.getUsername());
                    } else {
                        System.out.println("⚠️ " + winner.getUsername() + " không đủ tiền");
                    }
                }

                productRepository.save(p);
            }
        }
    }
}
