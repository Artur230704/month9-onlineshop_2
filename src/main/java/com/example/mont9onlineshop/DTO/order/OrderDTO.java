package com.example.mont9onlineshop.DTO.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
    private Long id;
    private String customer;
    private String email;
    private List<String> products;
    private String address;
    private double bill;
    private LocalDateTime date;
}

