package org.example.group_project.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdatePlanetDTO(
        @JsonProperty("planet_name")
        String planetName,
        @JsonProperty("radius_km")
        int radiusKm,
        @JsonProperty("type")
        String type,
        @JsonProperty("mass_kg")
        double massKg,
        @JsonProperty("orbital_period_days")
        int orbitalPeriodDays

) {
}
