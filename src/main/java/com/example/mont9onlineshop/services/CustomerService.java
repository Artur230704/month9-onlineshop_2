package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerRegisterDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.exceptions.CustomerAlreadyRegisteredException;
import com.example.mont9onlineshop.mappers.CustomerMapper;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {
    private CustomerRepository customerRepository;
    private ShoppingCartRepository shoppingCartRepository;

    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }


    public boolean register(CustomerRegisterDTO user) {

        if (customerRepository.existsByEmail(user.getEmail())){
            throw new CustomerAlreadyRegisteredException("The client with this email is already registered");
        }

        Customer customer = Customer.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .role("customer")
                .enabled(true)
                .build();

        customerRepository.save(customer);

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .customer(customer)
                .build();

        shoppingCartRepository.save(shoppingCart);
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
        Customer customer = customerRepository.findByEmail(email).get();
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return CustomerMapper.fromCustomer(customer);
    }

    public Boolean existsByEmail(String email){
        return customerRepository.existsByEmail(email);
    }
}
