package com.example.mont9onlineshop.DTO.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChangePasswordDTO {
    @NotEmpty(message = "Password can not be empty")
    @NotBlank(message = "Password can not be blank")
    private String currentPassword;

    @NotEmpty(message = "New password can not be empty")
    @NotBlank(message = "New password can not be blank")
    @Size(min = 4, max = 15, message = "New password length can not be less than 4 and more than 15")
    private String newPassword;
}
