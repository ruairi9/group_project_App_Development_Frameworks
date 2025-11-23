package org.example.group_project.dtos;

import org.example.group_project.dtos.PlanetDTO;

public record PlanetDTO (
        int planet_id,
        String planet_name,
        int radius_km,
        String type,
        double mass_kg,
        int orbital_period_days
) {}
