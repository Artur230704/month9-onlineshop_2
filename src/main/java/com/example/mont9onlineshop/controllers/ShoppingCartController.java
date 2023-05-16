package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartItemAddingDTO;
import com.example.mont9onlineshop.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping("/api/carts/{email}")
    public ResponseEntity<List<ShoppingCartDTO>> findShoppingCart(@PathVariable String email){
        return new ResponseEntity<>(shoppingCartService.findShoppingCart(email), HttpStatus.OK);
    }

    @PostMapping("/api/carts/items/add")
    public ResponseEntity<Boolean> addItemToCart(@Valid @RequestBody ShoppingCartItemAddingDTO dto, Principal principal){
        String email = principal.getName();
        return new ResponseEntity<>(shoppingCartService.addItemToCart(dto, email),HttpStatus.OK);
    }
}
