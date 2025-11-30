package org.example.group_project.dtos;

import org.example.group_project.entities.Moon;
import org.example.group_project.entities.Planet;

public class MoonMapper {
    public static Moon mapToEntity(MoonCreateDTO dto , Planet planet) {
        return new Moon(
                null,
                dto.name(),
                dto.diameterKm(),
                dto.orbitalPeriodDays(),
                planet
        );
    }
    public static MoonDTO mapMoonToMoonDTO(Moon m) {
        return new MoonDTO(
                m.getMoonId(),
                m.getName(),
                m.getDiameterKm(),
                m.getOrbitalPeriodDays(),
                m.getPlanet().getPlanet_id(),
                m.getPlanet().getPlanet_name()
        );
    }
}
