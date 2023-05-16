package com.example.mont9onlineshop.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors().stream()
                .map(e -> String.format("%s - %s",
                        e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());
        return  ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }

    @ExceptionHandler(CustomerAlreadyRegisteredException.class)
    public String handleCustomerAlreadyRegisteredException(CustomerAlreadyRegisteredException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "registration";
    }
}