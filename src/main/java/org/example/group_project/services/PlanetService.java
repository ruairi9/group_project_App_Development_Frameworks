package org.example.group_project.services;

import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.entities.Planet;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface PlanetService {
    List<PlanetDTO> findAll();
    PlanetDTO findByPlanetId(int id);
    Planet save(Planet planet);
    Planet findAllPlanetName(String planetName);
    Planet findByRadiusKm(int radiusKm);
    List<Planet> findByType(String type);
    Planet findByMassKg(double massKg);
    Planet findByOrbitalPeriodDays(int orbitalPeriodDays);
    void changePlanets(int id, String planetName, int radiusKm, String type, double massKg, int orbitalPeriodDays);
    List<Integer> findAllPlanetIdOnly();
    List<String> findAllPlanetNameOnly();
    List<Integer> findAllPlanetRadiusOnly();
    List<String> findAllPlanetTypeOnly();
    List<Double> findAllPlanetMassOnly();
    List<Integer> findAllPlanetOrbitalPeriodDaysOnly();
    void deleteById(int id);
}
