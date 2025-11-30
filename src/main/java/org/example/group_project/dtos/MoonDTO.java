package org.example.group_project.dtos;

public record MoonDTO(
        Long moonId,
        String name,
        Double diameterKm,
        Double orbitalPeriodDays,
        int planetId,
        String planetName
) {}
