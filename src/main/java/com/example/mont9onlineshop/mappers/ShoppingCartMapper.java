package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.entities.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {
    public static ShoppingCartDTO fromShoppingCart(ShoppingCart cart){
        return ShoppingCartDTO.builder()
                .id(cart.getId())
                .customer(cart.getCustomer().getUsername())
                .email(cart.getCustomer().getEmail())
                .products(cart.getShopCartItems().stream()
                        .map(item -> ProductMapper.fromProduct(item.getProduct()))
                        .collect(Collectors.toList()))
                .build();
    }
}
