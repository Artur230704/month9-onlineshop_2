package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByNameContainingIgnoreCase(String productName, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE LOWER(p.category.name) = LOWER(:categoryName)")
    Page<Product> findByCategoryName(String categoryName, Pageable pageable);

    Page<Product> findAllByPriceLessThan(double maxPrice, Pageable pageable);
}