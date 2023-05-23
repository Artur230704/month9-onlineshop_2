package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "(:category IS NULL OR LOWER(p.category.name) = LOWER(:category)) AND " +
            "(:min IS NULL OR p.price >= :min) AND " +
            "(:max IS NULL OR p.price <= :max) AND " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:description IS NULL OR LOWER(p.description) LIKE LOWER(CONCAT('%', :description, '%')))")
    Page<Product> searchProducts(
            @Param("category") String category,
            @Param("min") Double min,
            @Param("max") Double max,
            @Param("name") String name,
            @Param("description") String description,
            Pageable pageable);

    Optional<Product> findByName(String name);
}