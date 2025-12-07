package org.example.group_project.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record UpdatePlanetDTO(
        @NotBlank(message = "planet name cannot be blank")
        @Size(min = 2, max = 100, message = "planet name must be between 2 and 100 characters")
        @JsonProperty("planet_name")
        String planetName,
        @NotNull(message = "radius is required")
        @Positive(message = "radius must be positive")
        @JsonProperty("radius_km")
        int radiusKm,
        @NotBlank(message = "type is needed")
        @NotEmpty(message = "type cannot be blank")
        @JsonProperty("type")
        String type,
        @NotNull(message = "mass is required")
        @Positive(message = "mass must be positive")
        @JsonProperty("mass_kg")
        double massKg,
        @NotNull(message = "orbital period is required")
        @Positive(message = "orbital period must be positive")
        @JsonProperty("orbital_period_days")
        int orbitalPeriodDays

) {
}
