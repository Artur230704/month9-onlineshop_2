package com.example.mont9onlineshop.mappers;

import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static CustomerDTO fromCustomer(Customer customer){
        return CustomerDTO.builder()
                .username(customer.getUsername())
                .email(customer.getEmail())
                .role(customer.getRole())
                .enabled(customer.isEnabled())
                .build();
    }

}
