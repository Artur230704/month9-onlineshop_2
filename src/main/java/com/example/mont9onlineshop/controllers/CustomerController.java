package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(value = "/api/customers")
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/name/{username}")
    public ResponseEntity<List<CustomerDTO>> findByName(@PathVariable String username){
        return new ResponseEntity<>(customerService.findByName(username), HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/email/{email}")
    public ResponseEntity<CustomerDTO> findByEmail(@PathVariable String email){
        CustomerDTO customer = customerService.findByEmail(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/existence/{email}")
    public ResponseEntity<Boolean> checkExistence(@PathVariable String email){
        return new ResponseEntity<>(customerService.existsByEmail(email), HttpStatus.OK);
    }
}
