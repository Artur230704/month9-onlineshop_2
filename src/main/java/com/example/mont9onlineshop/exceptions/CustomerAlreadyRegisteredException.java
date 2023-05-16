package com.example.mont9onlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CustomerAlreadyRegisteredException extends RuntimeException {
    public CustomerAlreadyRegisteredException(String message) {
        super(message);
    }
}