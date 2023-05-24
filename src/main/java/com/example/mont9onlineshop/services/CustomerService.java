package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.customer.ChangePasswordDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerRegisterDTO;
import com.example.mont9onlineshop.DTO.customer.RecoverPasswordDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.entities.ShoppingCart;
import com.example.mont9onlineshop.exceptions.CustomerAlreadyRegisteredException;
import com.example.mont9onlineshop.mappers.CustomerMapper;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import com.example.mont9onlineshop.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
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
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return CustomerMapper.fromCustomer(customer);
    }

    public Boolean existsByEmail(String email){
        return customerRepository.existsByEmail(email);
    }

    public String changePassword(ChangePasswordDTO changePasswordDTO, String email) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Not found"));

        if (!encoder.matches(changePasswordDTO.getCurrentPassword(), customer.getPassword())) {
            return "Failed to change password. The current password is entered incorrectly";
        }

        if (changePasswordDTO.getCurrentPassword().equals(changePasswordDTO.getNewPassword())) {
            return "Failed to change password. The current password and the new password are the same.";
        }

        customer.setPassword(encoder.encode(changePasswordDTO.getNewPassword()));
        customerRepository.save(customer);
        return "The password has been changed successfully.";
    }

    public String recoverPassword(RecoverPasswordDTO recoverPasswordDTO) {
        Customer customer = customerRepository.findByEmail(recoverPasswordDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));

        int passwordLength = 10;

        String randomPassword = RandomStringUtils.randomAlphabetic(passwordLength).toLowerCase();
        customer.setPassword(encoder.encode(randomPassword));
        customerRepository.save(customer);

        return randomPassword;
    }
}
