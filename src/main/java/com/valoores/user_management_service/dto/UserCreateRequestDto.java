package com.valoores.user_management_service.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    @NotEmpty(message = "User Name cannot be empty")
    @NotNull(message = "User Name cannot be null")
    @Size(min = 3, max = 50, message = "User Name cannot exceed 50 characters")
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotEmpty(message = "DOB cannot be empty")
    @NotNull(message = "DOB cannot be null")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
}
