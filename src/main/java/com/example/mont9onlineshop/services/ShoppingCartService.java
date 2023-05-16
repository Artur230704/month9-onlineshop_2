package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartItemAddingDTO;
import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.entities.ShoppingCartItem;
import com.example.mont9onlineshop.mappers.ShoppingCartMapper;
import com.example.mont9onlineshop.repositories.ProductRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartItemRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ProductRepository productRepository;


    public List<ShoppingCartDTO> findShoppingCart(String email){
        return shoppingCartRepository.findCartByCustomer(email).stream()
                .map(ShoppingCartMapper::fromShoppingCart)
                .collect(Collectors.toList());
    }

    public boolean addItemToCart(ShoppingCartItemAddingDTO itemDTO, String email) {
        Product product = productRepository.findById(itemDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        ShoppingCart shoppingCart = shoppingCartRepository.findCartByCustomer(email)
                .orElseThrow(() -> new IllegalArgumentException("User's shopping cart not found"));

        ShoppingCartItem shoppingCartItem = ShoppingCartItem.builder()
                .product(product)
                .shoppingCart(shoppingCart)
                .build();

        shoppingCartItemRepository.save(shoppingCartItem);
        return true;
    }
}
