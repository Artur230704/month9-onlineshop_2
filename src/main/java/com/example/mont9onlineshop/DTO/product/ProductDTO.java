package com.example.mont9onlineshop.DTO.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private String description;
    private String category;
    private double price;
}
