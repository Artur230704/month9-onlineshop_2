package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    Optional<ShoppingCartItem> findByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);

    boolean existsByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);

    @Transactional
    @Modifying
    @Query("UPDATE ShoppingCartItem sci SET sci.quantity = sci.quantity + 1 WHERE sci = :shoppingCartItem")
    void increaseQuantity(@Param("shoppingCartItem") ShoppingCartItem shoppingCartItem);

    @Transactional
    @Modifying
    @Query("UPDATE ShoppingCartItem sci SET sci.quantity = sci.quantity - 1 WHERE sci = :shoppingCartItem AND sci.quantity > 0")
    void reduceQuantity(@Param("shoppingCartItem") ShoppingCartItem shoppingCartItem);

}
