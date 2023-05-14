package com.example.mont9onlineshop.repositories;

import com.example.mont9onlineshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order AS o WHERE o.customer.email = :email")
    List<Order> findCustomerOrders(String email);
}