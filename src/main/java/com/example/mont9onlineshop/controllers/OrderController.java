package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.order.OrderAddingDTO;
import com.example.mont9onlineshop.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public String getOrdersPage(Model model, Principal principal){
        String email = principal.getName();
        model.addAttribute("orders",orderService.findCustomerOrders(email));
        return "orders";
    }

    @PostMapping("/api/orders/add")
    public ResponseEntity<Boolean> makeOrder(@Valid @RequestBody OrderAddingDTO orderAddingDTO,
                                             Principal principal){
        String email = principal.getName();
        return new ResponseEntity<>(orderService.makeOrder(orderAddingDTO, email), HttpStatus.OK);
    }
}
