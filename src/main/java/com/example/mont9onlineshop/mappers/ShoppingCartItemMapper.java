package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartItemDisplayDTO;
import com.example.mont9onlineshop.entities.ShoppingCartItem;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartItemMapper {
    public static ShoppingCartItemDisplayDTO fromItem(ShoppingCartItem item){
        return ShoppingCartItemDisplayDTO.builder()
                .id(item.getId())
                .product(ProductMapper.fromProduct(item.getProduct()))
                .quantity(item.getQuantity())
                .build();
    }
}
