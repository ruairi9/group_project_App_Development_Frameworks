package org.example.group_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewUserDTO(@NotBlank(message = "Should not be blank.") @NotNull String userName,
                         @NotBlank @NotNull String password, @NotBlank @NotNull String role) {}
