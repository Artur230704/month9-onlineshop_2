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
public class ShoppingCartItemDTO {
    @NotNull(message = "You need to select a product to add/delete to the cart")
    @Positive(message = "You cannot add/delete a non-existent product")
    private Long productId;
}
