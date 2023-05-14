package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.review.ReviewDTO;
import com.example.mont9onlineshop.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public static ReviewDTO fromReview(Review review){
        return ReviewDTO.builder()
                .id(review.getId())
                .username(review.getCustomer().getUsername())
                .text(review.getText())
                .date(review.getDate())
                .build();
    }
}
