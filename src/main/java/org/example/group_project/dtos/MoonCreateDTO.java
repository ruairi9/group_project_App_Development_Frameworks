package org.example.group_project.dtos;

import jakarta.validation.constraints.*;

public record MoonCreateDTO (
        @NotBlank(message = "moon name is needed")
        @NotEmpty(message = "moon name cannot be blank")
        @Size(min = 2, max = 100, message = "moon name must be between 2 and 100 characters")
        String name,
        @Positive(message = "diameter must be positive")
        @NotNull(message = "diameter is required")
        Double diameterKm,
        @Positive(message = "orbital period must be positive")
        @NotNull(message = "orbital period is required")
        Double orbitalPeriodDays,
        @Positive(message = "planet id must be positive")
        @NotNull(message = "planet id is required")
        Long planetId
) {}
