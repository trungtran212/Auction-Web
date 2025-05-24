package com.example.InternProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InternProject.model.AuctionSession;
import com.example.InternProject.repository.AuctionSessionRepository;

import java.util.List;

@Service
public class AuctionSessionService {

    @Autowired
    private AuctionSessionRepository repository;

    public AuctionSession create(AuctionSession auctionSession) {
        return repository.save(auctionSession);
    }

    public List<AuctionSession> getAll() {
        return repository.findAll();
    }

    public AuctionSession getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
