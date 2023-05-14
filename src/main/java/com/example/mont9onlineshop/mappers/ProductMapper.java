package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDTO fromProduct(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .description(product.getDescription())
                .category(product.getCategory().getName())
                .price(product.getPrice())
                .build();
    }
}
