package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.DTO.review.ReviewAddingDTO;
import com.example.mont9onlineshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ResourceBundle;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ResourceBundle bundle;

    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("bundle", bundle);
        return "main-page";
    }

    @GetMapping("/api/products")
    public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "4") int size){
        return new ResponseEntity<>(productService.findAll(page,size), HttpStatus.OK);
    }

    @GetMapping("/api/products/search")
    public ResponseEntity<Page<ProductDTO>> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false, defaultValue = "0") double min,
            @RequestParam(required = false, defaultValue = "500000") double max,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductDTO> result = productService.findByParameters(category, min, max, name, description, pageRequest);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/products/review/{productName}")
    public String findAllComments(@PathVariable String productName, Model model){
        model.addAttribute("bundle", bundle);
        model.addAttribute("product", productService.findByName(productName));
        model.addAttribute("reviews", productService.findAllComments(productName));
        return "reviews-page";
    }

    @PostMapping("/api/products/reviews/add")
    public ResponseEntity<Boolean> addReview(Principal principal,@Valid @RequestBody ReviewAddingDTO reviewAddingDTO){
        String email = principal.getName();
        return new ResponseEntity<>(productService.addReview(email, reviewAddingDTO), HttpStatus.OK);
    }
}
