package org.example.group_project.dtos;

import jakarta.validation.constraints.*;

public record PlanetCreateDTO (
        @NotBlank(message = "planet name is needed")
        @NotEmpty(message = "planet name cannot be blank")
        @Size(min = 2, max = 100, message = "planet name must be between 2 and 100 characters")
        String planetName,
        @NotNull(message = "radius is required")
        @Positive(message = "radius must be positive")
        int radiusKm,
        @NotBlank(message = "type is needed")
        @NotEmpty(message = "type cannot be blank")
        @Size(min = 2, max = 50, message = "type must be between 2 and 50 characters")
        String type,
        @NotNull(message = "mass is required")
        @Positive(message = "mass must be positive")
        double massKg,
        @NotNull(message = "orbital period is required")
        @Positive(message = "orbital period must be positive")
        int orbitalPeriodDays)
{

}
