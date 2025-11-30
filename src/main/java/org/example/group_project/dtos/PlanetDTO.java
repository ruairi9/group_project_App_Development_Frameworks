package org.example.group_project.dtos;

import org.example.group_project.dtos.PlanetDTO;

public record PlanetDTO (
        int planetId,
        String planetName,
        int radiusKm,
        String type,
        double massKg,
        int orbitalPeriodDays
) {}
