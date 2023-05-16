package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    Optional<ShoppingCartItem> findByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);

    boolean existsByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);
}
