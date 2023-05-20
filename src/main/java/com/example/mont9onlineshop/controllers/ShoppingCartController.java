package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.shoppingCart.ShoppingCartDTO;
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
import java.util.Map;

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
    public ResponseEntity<Boolean> addItemToCart(@Valid @RequestBody Map<String, Object> requestData, Principal principal) {
        String email = principal.getName();
        Long productId = Long.valueOf(requestData.get("productId").toString());
        return new ResponseEntity<>(shoppingCartService.addItemToCart(productId, email), HttpStatus.OK);
    }


    @PostMapping("/api/carts/items/remove")
    public ResponseEntity<Boolean> removeFromCart(@Valid @RequestBody Map<String, Object> requestData, Principal principal) {
        String email = principal.getName();
        Long productId = Long.valueOf(requestData.get("productId").toString());
        return new ResponseEntity<>(shoppingCartService.removeItemFromCart(productId, email), HttpStatus.OK);
    }
}
