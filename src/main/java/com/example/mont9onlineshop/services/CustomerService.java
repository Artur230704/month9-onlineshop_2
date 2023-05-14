package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerRegisterDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.mappers.CustomerMapper;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder encoder;

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


    public List<CustomerDTO> findAll(){
        return customerRepository.findAll().stream()
                .map(CustomerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> findByName(String username){
        List<Customer> customers = customerRepository.findByUsernameIsContainingIgnoreCase(username);
        if (customers == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return customers.stream()
                .map(CustomerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CustomerDTO findByEmail(String email){
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return CustomerMapper.fromCustomer(customer);
    }

    public Boolean existsByEmail(String email){
        return customerRepository.existsByEmail(email);
    }
}
