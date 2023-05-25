package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.product.ProductDTO;
import com.example.mont9onlineshop.DTO.review.ReviewAddingDTO;
import com.example.mont9onlineshop.DTO.review.ReviewDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.entities.Review;
import com.example.mont9onlineshop.mappers.ProductMapper;
import com.example.mont9onlineshop.mappers.ReviewMapper;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import com.example.mont9onlineshop.repositories.ProductRepository;
import com.example.mont9onlineshop.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

    public ProductDTO findByName(String productName){
        return ProductMapper.fromProduct(productRepository.findByName(productName).get());
    }


    public Page<ProductDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable)
                .map(ProductMapper::fromProduct);
    }

    public List<ReviewDTO> findAllComments(String productName){
        return reviewRepository.findReviewsByProductName(productName).stream()
                .map(ReviewMapper::fromReview)
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> findByParameters(String category, Double min, Double max, String name, String description, Pageable pageable){
        return productRepository.searchProducts(category,min,max,name,description,pageable)
                .map(ProductMapper::fromProduct);
    }

    public boolean addReview(String email, ReviewAddingDTO reviewAddingDTO) {
        Customer customer = customerRepository.findByEmail(email).get();
        Product product = productRepository.findByName(reviewAddingDTO.getProduct()).get();

        Review review = new Review();
        review.setCustomer(customer);
        review.setProduct(product);
        review.setText(reviewAddingDTO.getText());
        review.setDate(LocalDateTime.now());
        reviewRepository.save(review);
        return true;
    }
}
