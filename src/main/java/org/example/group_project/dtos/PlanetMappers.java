package org.example.group_project.dtos;

import org.example.group_project.entities.Planet;

public class PlanetMappers {

    public static PlanetDTO mapPlanettoPlanetDTO(Planet p) {
        return new PlanetDTO(
                p.getPlanetId(),
                p.getPlanetName(),
                p.getRadiusKm(),
                p.getType(),
                p.getMassKg(),
                p.getOrbitalPeriodDays()
        );
    }
    public static Planet maptoEntity(PlanetCreateDTO dto){
        Planet p = new Planet();
        p.setPlanetName(dto.planet_name());
        p.setRadiusKm(dto.radius_km());
        p.setType(dto.type());
        p.setMassKg(dto.mass_kg());
        p.setOrbitalPeriodDays(dto.orbital_period_days());
        return p;
    }

}
