package org.example.group_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotBlank(message = "User name Should not be blank.")
        @Size(min = 2, max = 100, message = "User name must be between 2 and 100 characters")
        String userName,
        @NotBlank(message = "password Should not be blank.")
        @Size(min = 2, max = 100, message = "password must be between 2 and 100 characters")
        String password,
        @NotBlank(message = "role Should not be blank.")
        @Size(min = 2, max = 100, message = "role must be between 2 and 100 characters")
        String role) {}
