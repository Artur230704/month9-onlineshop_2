package com.example.mont9onlineshop.DTO.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderAddingDTO {
    @NotNull(message = "Customer cannot be null")
    private String email;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "Order items cannot be null")
    @Size(min = 1, message = "There must be at least one order item")
    private List<OrderItemDTO> orderItems;
}
