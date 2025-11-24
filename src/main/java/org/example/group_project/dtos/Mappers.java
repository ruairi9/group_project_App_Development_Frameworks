package org.example.group_project.dtos;

import org.example.group_project.entities.Planet;

public class Mappers {

    public static PlanetDTO mapPlanettoPlanetDTO(Planet p){
        return new PlanetDTO(
                p.getPlanet_id(),
                p.getPlanet_name(),
                p.getRadius_km(),
                p.getType(),
                p.getMass_kg(),
                p.getOrbital_period_days()
        );
    }
}
