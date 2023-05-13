package com.example.mont9onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameIsContainingIgnoreCase(String username);
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}