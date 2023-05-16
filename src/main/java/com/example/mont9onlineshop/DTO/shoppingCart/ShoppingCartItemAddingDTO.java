package com.example.mont9onlineshop.DTO.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartItemAddingDTO {
    @NotNull(message = "You need to select a product to add to the cart")
    @Positive(message = "You cannot add a non-existent product to the cart")
    private Long productId;
}
