package org.example.group_project.services;

import org.example.group_project.dtos.PlanetMappers;
import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.entities.Planet;
import org.example.group_project.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.example.group_project.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private PlanetRepository planetRepository;

    @Override
    public List<PlanetDTO> findAll() {
        return planetRepository.findAll().stream()
                .map(PlanetMappers::mapPlanettoPlanetDTO)
                .toList();
    }

    @Override
    public PlanetDTO findByPlanetId(int planetId) {
        Planet planet = planetRepository.findById(planetId)
                .orElseThrow(() ->
                        new NotFoundException("Planet with id " + planetId + " was not found")
                );

        return PlanetMappers.mapPlanettoPlanetDTO(planet);
    }

    @Override
    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Planet findAllPlanetName(String planetName) {
        return planetRepository.findByPlanetName(planetName)
                .orElseThrow(() -> new NotFoundException("Planet with name " + planetName + " was not found"));
    }

    @Override
    public Planet findByRadiusKm(int radiusKm) {
        return planetRepository.findByRadiusKm(radiusKm)
                .orElseThrow(() -> new NotFoundException("Planet with radius " + radiusKm + " was not found"));
    }

    @Override
    public List<Planet> findByType(String type) {
        List<Planet> planets = planetRepository.findByType(type);
        if (planets.isEmpty()) {
            throw new NotFoundException("No planets with type " + type + " found");
        }
        return planets;
    }

    @Override
    public Planet findByMassKg(double massKg) {
        return planetRepository.findByMassKg(massKg)
                .orElseThrow(() -> new NotFoundException("Planet with mass " + massKg + " was not found"));
    }

    @Override
    public Planet findByOrbitalPeriodDays(int OrbitalPeriodDays) {
        return planetRepository.findByOrbitalPeriodDays(OrbitalPeriodDays)
                .orElseThrow(() -> new NotFoundException("Planet with mass " + OrbitalPeriodDays + " was not found"));
    }

    @Override
    public void changePlanets(int id, String planetName, int radiusKm, String type, double massKg, int orbitalPeriodDays) {
        Planet planet = planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet with id " + id + " was not found"));
        planet.setPlanetName(planetName);
        planet.setRadiusKm(radiusKm);
        planet.setType(type);
        planet.setMassKg(massKg);
        planet.setOrbitalPeriodDays(orbitalPeriodDays);
        planetRepository.save(planet);
    }

    @Override
    public List<Integer> findAllPlanetIdOnly() {
        return planetRepository.findAllPlanetIdOnly();
    }

    @Override
    public List<String> findAllPlanetNameOnly() {
        return planetRepository.findAllPlanetNameOnly();
    }

    @Override
    public List<Integer> findAllPlanetRadiusOnly() {
        return planetRepository.findAllPlanetRadiusOnly();
    }

    @Override
    public List<String> findAllPlanetTypeOnly() {
        return planetRepository.findAllPlanetTypeOnly();
    }

    @Override
    public List<Double> findAllPlanetMassOnly() {
        return planetRepository.findAllPlanetMassOnly();
    }

    @Override
    public List<Integer> findAllPlanetOrbitalPeriodDaysOnly() {
        return planetRepository.findAllPlanetOrbitalPeriodDaysOnly();
    }

    @Override
    public void deleteById(int planetId) {
        int rowsDeleted = planetRepository.deleteById(planetId);
        if(rowsDeleted== 0) {
            throw new NotFoundException("Planet with id " + planetId + " was not found");
        }
    }
}
