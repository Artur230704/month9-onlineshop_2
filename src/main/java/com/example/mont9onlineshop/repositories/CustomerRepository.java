package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByUsernameIsContainingIgnoreCase(String username);
    Customer findByEmail(String email);
    Boolean existsByEmail(String email);
}