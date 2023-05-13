package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT c FROM Review c WHERE c.product.name = :productName")
    List<Review> findReviewsByProductName(String productName);
}