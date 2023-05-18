package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.DTO.review.ReviewDTO;
import com.example.mont9onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String getMainPage(){
        return "main-page";
    }

    @GetMapping("/api/products")
    public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "4") int size){
        return new ResponseEntity<>(productService.findAll(page,size), HttpStatus.OK);
    }

    @GetMapping("/api/products/review/{productName}")
    public ResponseEntity<List<ReviewDTO>> findAllComments(@PathVariable String productName){
        return new ResponseEntity<>(productService.findAllComments(productName),HttpStatus.OK);
    }

    @GetMapping("/api/products/search")
    public ResponseEntity<Page<ProductDTO>> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false, defaultValue = "0") double min,
            @RequestParam(required = false, defaultValue = "500000") double max,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductDTO> result = productService.findByParameters(category, min, max, name, description, pageRequest);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
