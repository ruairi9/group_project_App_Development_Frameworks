package org.example.group_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PlanetCreateDTO (
        @NotBlank(message = "planet name is needed")
        @NotEmpty(message = "planet name cannot be blank")
        String planetName,
        int radiusKm,
        @NotBlank(message = "type is needed")
        @NotEmpty(message = "type cannot be blank")
        String type,
        double massKg,
        int orbitalPeriodDays)
{

}
