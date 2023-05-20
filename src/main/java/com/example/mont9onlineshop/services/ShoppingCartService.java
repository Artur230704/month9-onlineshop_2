package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.entities.ShoppingCartItem;
import com.example.mont9onlineshop.mappers.ShoppingCartMapper;
import com.example.mont9onlineshop.repositories.ProductRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartItemRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ProductRepository productRepository;


    public ShoppingCartDTO findShoppingCart(String email){
        return ShoppingCartMapper.fromShoppingCart(shoppingCartRepository.findCartByCustomer(email).get());
    }

    public boolean addItemToCart(Long productId, String email) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        ShoppingCart shoppingCart = shoppingCartRepository.findCartByCustomer(email)
                .orElseThrow(() -> new IllegalArgumentException("User's shopping cart not found"));

        boolean isProductInCart = shoppingCartItemRepository.existsByShoppingCartAndProduct(shoppingCart, product);

        if (isProductInCart) {
            return false;
        }

        ShoppingCartItem shoppingCartItem = ShoppingCartItem.builder()
                .product(product)
                .shoppingCart(shoppingCart)
                .quantity(1)
                .build();

        shoppingCartItemRepository.save(shoppingCartItem);
        return true;
    }
    public boolean removeItemFromCart(Long productId, String email) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        ShoppingCart shoppingCart = shoppingCartRepository.findCartByCustomer(email)
                .orElseThrow(() -> new IllegalArgumentException("User's shopping cart not found"));

        ShoppingCartItem shoppingCartItem = shoppingCartItemRepository.findByShoppingCartAndProduct(shoppingCart, product)
                .orElseThrow(() -> new IllegalArgumentException("Item not found in the shopping cart"));

        shoppingCartItemRepository.delete(shoppingCartItem);
        return true;
    }


}
