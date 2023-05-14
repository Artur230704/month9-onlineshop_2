package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.order.OrderDTO;
import com.example.mont9onlineshop.entities.Order;
import com.example.mont9onlineshop.entities.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    public static OrderDTO fromOrder(Order order){
        Map<String, Integer> productMap = order.getOrderItems().stream()
                .collect(Collectors.toMap(item -> item.getProduct().getName(), OrderItem::getQuantity));

        return OrderDTO.builder()
                .id(order.getId())
                .customer(order.getCustomer().getUsername())
                .email(order.getCustomer().getEmail())
                .products(productMap)
                .address(order.getAddress())
                .bill(order.getBill())
                .date(order.getDate())
                .build();
    }
}