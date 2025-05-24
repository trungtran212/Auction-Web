package com.example.InternProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.InternProject.model.AuctionSession;
import com.example.InternProject.service.AuctionSessionService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/auction-sessions")
public class AuctionSessionController {

    @Autowired
    private AuctionSessionService service;

    @PostMapping
    public AuctionSession create(@RequestBody AuctionSession auctionSession) {
        return service.create(auctionSession);
    }

    @GetMapping
    public List<AuctionSession> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AuctionSession getById(@PathVariable Long id) {
        return service.getById(id);
    }
}