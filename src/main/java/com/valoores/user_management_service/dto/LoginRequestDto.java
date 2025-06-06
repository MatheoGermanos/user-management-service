package com.valoores.user_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "User Name cannot be blank")
    @NotEmpty(message = "User Name cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
