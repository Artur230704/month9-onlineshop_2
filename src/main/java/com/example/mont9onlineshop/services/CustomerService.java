package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.user.CustomerRegisterDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByEmail(email));
        if (!customer.isPresent()) {
            throw new UsernameNotFoundException("Customer not found");
        }
        return customer.get();
    }


    public boolean register(CustomerRegisterDTO user) {
        Customer customer = customerRepository.findByEmail(user.getEmail());
        if (customer != null) {
            return false;
        }
        customer = Customer.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .role("customer")
                .enabled(true)
                .build();

        customerRepository.save(customer);
        return true;
    }
}
