package org.example.group_project.controllers;

import jakarta.validation.Valid;
import org.example.group_project.dtos.PlanetCreateDTO;
import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.dtos.PlanetMappers;
import org.example.group_project.dtos.UpdatePlanetDTO;
import org.example.group_project.entities.Planet;
import org.example.group_project.exceptions.NotFoundException;
import org.example.group_project.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/planets")
public class RestPlanetService {

    private final PlanetService planetService;

    @GetMapping
    public List<PlanetDTO> findAllPlanets() {
        return planetService.findAll();
    }

    @GetMapping("/id/{planet_id}")
    public PlanetDTO findPlanetById(@PathVariable ("planet_id") int planetId) throws NotFoundException  {
        return planetService.findByPlanetId(planetId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO createPlanet(@Valid @RequestBody PlanetCreateDTO planetCreateDTO) {
        Planet newPlanet = PlanetMappers.maptoEntity(planetCreateDTO);
        newPlanet = planetService.save(newPlanet);
        return PlanetMappers.mapPlanettoPlanetDTO(newPlanet);
    }

    @GetMapping("/name/{planet_name}")
    public Planet findAllPlanetName(@PathVariable ("planet_name") String planetName)  throws NotFoundException {
        return planetService.findAllPlanetName(planetName);
    }

    @GetMapping("/radius/{radius_km}")
    public Planet findByRadiusKm(@PathVariable ("radius_km") int radiusKm)  throws NotFoundException {
        return planetService.findByRadiusKm(radiusKm);
    }

    @GetMapping("/type/{type}")
    public List<Planet> findByType(@PathVariable("type") String type) throws NotFoundException {
        return planetService.findByType(type);
    }

    @GetMapping("/mass/{massKg}")
    public Planet findByMassKg(@PathVariable ("massKg") double massKg)  throws NotFoundException {
        return planetService.findByMassKg(massKg);
    }

    @GetMapping("/orbitalPeriodDays/{orbitalPeriodDays}")
    public Planet findByOrbitalPeriodDays(@PathVariable ("orbitalPeriodDays") int orbitalPeriodDays)  throws NotFoundException {
        return planetService.findByOrbitalPeriodDays(orbitalPeriodDays);
    }

    @PatchMapping("/change/{planet_id}")
    public void updatePlanetRecord(@PathVariable("planet_id") int planetId, @Valid @RequestBody UpdatePlanetDTO dto) {
        planetService.changePlanets(planetId, dto.planetName(), dto.radiusKm(), dto.type(), dto.massKg(), dto.orbitalPeriodDays());
    }

    @GetMapping("/id/only")
    public List<Integer> findAllPlanetIdOnly() {
        return planetService.findAllPlanetIdOnly();
    }

    @GetMapping("/name/only")
    public List<String> findAllPlanetNameOnly() {
        return planetService.findAllPlanetNameOnly();
    }

    @GetMapping("/radius/only")
    public List<Integer> findAllPlanetRadiusOnly() {
        return planetService.findAllPlanetRadiusOnly();
    }

    @GetMapping("/type/only")
    public List<String> findAllPlanetTypeOnly() {
        return planetService.findAllPlanetTypeOnly();
    }

    @GetMapping("/mass/only")
    public List<Double> findAllPlanetMassOnly() {
        return planetService.findAllPlanetMassOnly();
    }

    @GetMapping("/orbitalPeriodDays/only")
    public List<Integer> findAllPlanetOrbitalPeriodDaysOnly() {
        return planetService.findAllPlanetOrbitalPeriodDaysOnly();
    }

    @DeleteMapping("/id/{planet_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("planet_id") int planetId) throws NotFoundException {
        planetService.deleteById(planetId);
    }
}
