package com.example.mont9onlineshop.DTO.shoppingCart;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShoppingCartDTO {
    private Long id;
    private String customer;
    private String email;
    private List<ProductDTO> products;
}
