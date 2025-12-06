package org.example.group_project.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.group_project.dtos.PlanetCreateDTO;
import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.dtos.PlanetMappers;
import org.example.group_project.dtos.UpdatePlanetDTO;
import org.example.group_project.entities.Planet;
import org.example.group_project.services.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/planets")
public class RestPlanetService {

    private final PlanetService planetService;

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping
    public List<PlanetDTO> findAllPlanets() {
        return planetService.findAll();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/id/{planet_id}")
    public PlanetDTO findPlanetById(@PathVariable("planet_id") int planetId) {
        return planetService.findByPlanetId(planetId);
    }

    @PreAuthorize("hasAnyRole('STAFF','ADMIN')")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO createPlanet(@Valid @RequestBody PlanetCreateDTO planetCreateDTO) {
        Planet newPlanet = PlanetMappers.maptoEntity(planetCreateDTO);
        newPlanet = planetService.save(newPlanet);
        return PlanetMappers.mapPlanettoPlanetDTO(newPlanet);
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/name/{planet_name}")
    public Planet findAllPlanetName(@PathVariable("planet_name") String planetName) {
        return planetService.findAllPlanetName(planetName);
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/radius/{radius_km}")
    public Planet findByRadiusKm(@PathVariable("radius_km") int radiusKm) {
        return planetService.findByRadiusKm(radiusKm);
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/type/{type}")
    public List<Planet> findByType(@PathVariable("type") String type) {
        return planetService.findByType(type);
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/mass/{massKg}")
    public Planet findByMassKg(@PathVariable("massKg") double massKg) {
        return planetService.findByMassKg(massKg);
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/orbitalPeriodDays/{orbitalPeriodDays}")
    public Planet findByOrbitalPeriodDays(@PathVariable("orbitalPeriodDays") int orbitalPeriodDays) {
        return planetService.findByOrbitalPeriodDays(orbitalPeriodDays);
    }

    @PreAuthorize("hasAnyRole('STAFF','ADMIN')")
    @PatchMapping("/change/{planet_id}")
    public void updatePlanetRecord(@PathVariable("planet_id") int planetId,
                                   @Valid @RequestBody UpdatePlanetDTO dto) {
        planetService.changePlanets(planetId, dto.planetName(), dto.radiusKm(), dto.type(),
                dto.massKg(), dto.orbitalPeriodDays());
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/id/only")
    public List<Integer> findAllPlanetIdOnly() {
        return planetService.findAllPlanetIdOnly();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/name/only")
    public List<String> findAllPlanetNameOnly() {
        return planetService.findAllPlanetNameOnly();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/radius/only")
    public List<Integer> findAllPlanetRadiusOnly() {
        return planetService.findAllPlanetRadiusOnly();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/type/only")
    public List<String> findAllPlanetTypeOnly() {
        return planetService.findAllPlanetTypeOnly();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/mass/only")
    public List<Double> findAllPlanetMassOnly() {
        return planetService.findAllPlanetMassOnly();
    }

    @PreAuthorize("hasAnyRole('STUDENT','STAFF','ADMIN')")
    @GetMapping("/orbitalPeriodDays/only")
    public List<Integer> findAllPlanetOrbitalPeriodDaysOnly() {
        return planetService.findAllPlanetOrbitalPeriodDaysOnly();
    }

    @PreAuthorize("hasAnyRole('STAFF','ADMIN')")
    @DeleteMapping("/id/{planet_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("planet_id") int planetId) {
        planetService.deleteById(planetId);
    }
}
