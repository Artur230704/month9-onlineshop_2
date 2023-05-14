package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.mappers.ShoppingCartMapper;
import com.example.mont9onlineshop.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCartDTO> findShoppingCart(String email){
        return shoppingCartRepository.findCartByCustomer(email).stream()
                .map(ShoppingCartMapper::fromShoppingCart)
                .collect(Collectors.toList());
    }
}
