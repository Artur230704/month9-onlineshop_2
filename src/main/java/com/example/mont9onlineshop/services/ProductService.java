package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.DTO.review.ReviewDTO;
import com.example.mont9onlineshop.mappers.ProductMapper;
import com.example.mont9onlineshop.mappers.ReviewMapper;
import com.example.mont9onlineshop.repositories.ProductRepository;
import com.example.mont9onlineshop.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public Page<ProductDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable)
                .map(ProductMapper::fromProduct);
    }

    public Page<ProductDTO> findAllByName(String productName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByNameContainingIgnoreCase(productName, pageable)
                .map(ProductMapper::fromProduct);
    }

    public Page<ProductDTO> findAllByCategoryName(String categoryName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategoryName(categoryName, pageable)
                .map(ProductMapper::fromProduct);
    }

    public Page<ProductDTO> findAllByPrice(double price, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByPriceLessThan(price, pageable)
                .map(ProductMapper::fromProduct);
    }

    public Page<ProductDTO> findAllByDescription(String description, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByDescriptionContainingIgnoreCase(description, pageable)
                .map(ProductMapper::fromProduct);
    }

    public List<ReviewDTO> findAllComments(String productName){
        return reviewRepository.findReviewsByProductName(productName).stream()
                .map(ReviewMapper::fromReview)
                .collect(Collectors.toList());
    }
}
