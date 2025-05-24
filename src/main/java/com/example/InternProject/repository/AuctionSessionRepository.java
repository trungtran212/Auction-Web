package com.example.InternProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InternProject.model.AuctionSession;

public interface AuctionSessionRepository extends JpaRepository<AuctionSession, Long> {
}