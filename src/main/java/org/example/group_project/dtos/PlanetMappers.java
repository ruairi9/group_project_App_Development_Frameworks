package org.example.group_project.dtos;

import org.example.group_project.entities.Planet;

public class PlanetMappers {

    public static PlanetDTO mapPlanettoPlanetDTO(Planet p) {
        return new PlanetDTO(
                p.getPlanet_id(),
                p.getPlanet_name(),
                p.getRadius_km(),
                p.getType(),
                p.getMass_kg(),
                p.getOrbital_period_days()
        );
    }
    public static Planet maptoEntity(PlanetCreateDTO dto){
        Planet p = new Planet();
        p.setPlanet_name(dto.planet_name());
        p.setRadius_km(dto.radius_km());
        p.setType(dto.type());
        p.setMass_kg(dto.mass_kg());
        p.setOrbital_period_days(dto.orbital_period_days());
        return p;
    }

}
