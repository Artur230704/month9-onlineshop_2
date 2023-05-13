package com.example.mont9onlineshop.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRegisterDTO {
    @NotEmpty(message = "Username can not be empty")
    @NotBlank(message = "Username can not be blank")
    @Size(min = 2, max = 30, message = "Username length can not be less than 2 and more than 30")
    private String username;
    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Password can not be empty")
    @NotBlank(message = "Password can not be blank")
    @Size(min = 4, max = 15, message = "password length can not be less than 4 and more than 15")
    private String password;
}
