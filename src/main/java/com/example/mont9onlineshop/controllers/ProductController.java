package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.DTO.review.ReviewDTO;
import com.example.mont9onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping("/api/products/name/{name}")
    public ResponseEntity<Page<ProductDTO>> findAllByName(@PathVariable String name,
                                                          @RequestParam(name = "page", defaultValue = "0") int page,
                                                          @RequestParam(name = "size", defaultValue = "4") int size) {
        return new ResponseEntity<>(productService.findAllByName(name, page, size), HttpStatus.OK);
    }

    @GetMapping("/api/products/category/{categoryName}")
    public ResponseEntity<Page<ProductDTO>> findAllByCategoryName(@PathVariable String categoryName,
                                                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                                                  @RequestParam(name = "size", defaultValue = "4") int size) {
        return new ResponseEntity<>(productService.findAllByCategoryName(categoryName, page, size), HttpStatus.OK);
    }

    @GetMapping("/api/products/price/{price}")
    public ResponseEntity<Page<ProductDTO>> findAllByPrice(@PathVariable double price,
                                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "4") int size) {
        return new ResponseEntity<>(productService.findAllByPrice(price, page, size), HttpStatus.OK);
    }

    @GetMapping("/api/products/description/{description}")
    public ResponseEntity<Page<ProductDTO>> findAllByDescription(@PathVariable String description,
                                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "4") int size) {
        return new ResponseEntity<>(productService.findAllByDescription(description, page, size), HttpStatus.OK);
    }

    @GetMapping("/api/products/review/{productName}")
    public ResponseEntity<List<ReviewDTO>> findAllComments(@PathVariable String productName){
        return new ResponseEntity<>(productService.findAllComments(productName),HttpStatus.OK);
    }
}
