package com.example.InternProject.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.model.Bid;
import com.example.InternProject.service.BidService;

@RestController
@RequestMapping("/bid")
@PreAuthorize("hasRole('USER')")
public class BidController {
    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/place")
    public ResponseEntity<Bid> placeBid(
            @RequestParam Long productId,
            @RequestParam double amount,
            Principal principal) {
        Bid bid = bidService.placeBid(principal.getName(), productId, amount);
        return ResponseEntity.ok(bid);
    }
}
