package org.example.group_project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MoonCreateDTO (
        @NotBlank(message = "moon name is needed")
        @NotEmpty(message = "moon name cannot be blank")
        String name,

        @NotNull(message = "diameter is required")
        Double diameterKm,

        @NotNull(message = "orbital period is required")
        Double orbitalPeriodDays,

        @NotNull(message = "planet id is required")
        Long planetId
) {}
