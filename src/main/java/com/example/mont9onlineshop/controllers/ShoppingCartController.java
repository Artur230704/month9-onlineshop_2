package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartItemDTO;
import com.example.mont9onlineshop.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping("/cart")
    public String getShoppingCartPage(){
        return "shopping-cart-page";
    }

    @GetMapping("/api/carts")
    public ResponseEntity<ShoppingCartDTO> findShoppingCart(Principal principal){
        String email = principal.getName();
        return new ResponseEntity<>(shoppingCartService.findShoppingCart(email), HttpStatus.OK);
    }

    @PostMapping("/api/carts/items/add")
    public ResponseEntity<Boolean> addItemToCart(@Valid @RequestBody ShoppingCartItemDTO dto, Principal principal){
        String email = principal.getName();
        return new ResponseEntity<>(shoppingCartService.addItemToCart(dto, email),HttpStatus.OK);
    }

    @PostMapping("/api/carts/items/delete")
    public ResponseEntity<Boolean> deleteItemFromCart(@Valid @RequestBody ShoppingCartItemDTO dto, Principal principal){
        String email = principal.getName();
        return new ResponseEntity<>(shoppingCartService.removeItemFromCart(dto, email),HttpStatus.OK);
    }
}
