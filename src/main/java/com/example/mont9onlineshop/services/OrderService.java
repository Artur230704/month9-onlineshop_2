package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.order.OrderDTO;
import com.example.mont9onlineshop.mappers.OrderMapper;
import com.example.mont9onlineshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderDTO> findCustomerOrders(String email){
        return orderRepository.findAllByUserEmail(email).stream()
                .map(OrderMapper::fromOrder)
                .collect(Collectors.toList());
    }

}
