package com.example.InternProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InternProject.model.Bid;
import com.example.InternProject.model.Product;
import com.example.InternProject.model.User;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByUser(User user);

    List<Bid> findByProduct(Product product);

    Optional<Bid> findTopByProductOrderByAmountDesc(Product product);

}