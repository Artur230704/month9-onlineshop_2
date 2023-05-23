package com.example.mont9onlineshop.DTO.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewAddingDTO {
    @NotNull(message = "product can not be empty")
    private String product;
    @NotBlank(message = "review text can not be blank")
    @NotEmpty(message = "review text can not be empty")
    private String text;
}
