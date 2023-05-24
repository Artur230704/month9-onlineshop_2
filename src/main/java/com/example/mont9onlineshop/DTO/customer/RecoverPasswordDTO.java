package com.example.mont9onlineshop.DTO.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecoverPasswordDTO {
    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    @Email(message = "Email is not valid")
    private String email;
}
