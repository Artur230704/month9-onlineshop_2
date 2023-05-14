package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.order.OrderDTO;
import com.example.mont9onlineshop.entities.Order;
import com.example.mont9onlineshop.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    public static OrderDTO fromOrder(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .customer(order.getCustomer().getUsername())
                .email(order.getCustomer().getEmail())
                .products(order.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.toList()))
                .address(order.getAddress())
                .bill(order.getBill())
                .date(order.getDate())
                .build();
    }
}