package com.example.InternProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InternProject.entity.BidEntity;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, Long> {

}
