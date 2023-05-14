package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

}
