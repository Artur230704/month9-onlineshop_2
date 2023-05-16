package com.example.mont9onlineshop.services;

import com.example.mont9onlineshop.DTO.order.OrderAddingDTO;
import com.example.mont9onlineshop.DTO.order.OrderDTO;
import com.example.mont9onlineshop.DTO.order.OrderItemDTO;
import com.example.mont9onlineshop.entities.Customer;
import com.example.mont9onlineshop.entities.Order;
import com.example.mont9onlineshop.entities.OrderItem;
import com.example.mont9onlineshop.entities.Product;
import com.example.mont9onlineshop.mappers.OrderMapper;
import com.example.mont9onlineshop.repositories.CustomerRepository;
import com.example.mont9onlineshop.repositories.OrderItemRepository;
import com.example.mont9onlineshop.repositories.OrderRepository;
import com.example.mont9onlineshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    public List<OrderDTO> findCustomerOrders(String email){
        return orderRepository.findCustomerOrders(email).stream()
                .map(OrderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean makeOrder(OrderAddingDTO orderDTO) {
        Order order = new Order();
        Customer customer = customerRepository.findByEmail(orderDTO.getEmail()).get();
        if (customer == null){
            throw new IllegalArgumentException("Customer not found");
        }
        order.setCustomer(customer);
        order.setAddress(orderDTO.getAddress());
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            Product product = productRepository.findById(orderItemDTO.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));
            if (product.getQuantity() < orderItemDTO.getQuantity()) {
                throw new IllegalArgumentException("Insufficient product quantity");
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);

            product.setQuantity(product.getQuantity() - orderItem.getQuantity());
            orderItemRepository.save(orderItem);
        }
        order.setOrderItems(orderItems);
        double bill = orderItems.stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
        order.setBill(bill);
        order.setDate(LocalDateTime.now());
        orderRepository.save(order);
        return true;
    }
}
