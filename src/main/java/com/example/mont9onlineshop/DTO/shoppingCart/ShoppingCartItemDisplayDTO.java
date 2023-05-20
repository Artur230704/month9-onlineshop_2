package com.example.mont9onlineshop.DTO.shoppingCart;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartItemDisplayDTO {
    private Long id;
    private ProductDTO product;
    private Integer quantity;
}
