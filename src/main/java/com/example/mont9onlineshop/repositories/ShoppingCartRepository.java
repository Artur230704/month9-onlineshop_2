package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(value = "SELECT s FROM ShoppingCart AS s WHERE s.customer.email = :email")
    List<ShoppingCart> findCartByCustomer(String email);
}
