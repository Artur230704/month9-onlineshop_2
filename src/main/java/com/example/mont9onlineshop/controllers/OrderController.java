package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.order.OrderDTO;
import com.example.mont9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/api/orders/{email}")
    public ResponseEntity<List<OrderDTO>> findCustomerOrders(@PathVariable String email){
        return new ResponseEntity<>(orderService.findCustomerOrders(email),HttpStatus.OK);
    }
}
