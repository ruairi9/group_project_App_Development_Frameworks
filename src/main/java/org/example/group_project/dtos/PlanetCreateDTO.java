package org.example.group_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlanetCreateDTO (
        @NotBlank(message = "planet name is needed")
        @NotEmpty(message = "planet name cannot be blank")
        String planetName,
        @NotNull(message = "radius is required")
        int radiusKm,
        @NotBlank(message = "type is needed")
        @NotEmpty(message = "type cannot be blank")
        String type,
        @NotNull(message = "mass is required")
        double massKg,
        @NotNull(message = "orbital period is required")
        int orbitalPeriodDays)
{

}
