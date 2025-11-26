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
    public PlanetDTO findPlanetById(@PathVariable ("planet_id") int planet_id) throws NotFoundException  {
        return planetService.findByPlanetId(planet_id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO createPlanet(@Valid @RequestBody PlanetCreateDTO planetCreateDTO) {
        Planet newPlanet = PlanetMappers.maptoEntity(planetCreateDTO);
        newPlanet = planetService.save(newPlanet);
        return PlanetMappers.mapPlanettoPlanetDTO(newPlanet);
    }

    @GetMapping("/name/{planet_name}")
    public Planet findAllPlanetName(@PathVariable ("planet_name") String planet_name)  throws NotFoundException {
        return planetService.findAllPlanetName(planet_name);
    }

    @GetMapping("/radius/{radius_km}")
    public Planet findByRadiusKm(@PathVariable ("radius_km") int radius_km)  throws NotFoundException {
        return planetService.findByRadiusKm(radius_km);
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

    //  @GetMapping("/{planet_name}")
   // void findAllPlanetName(@PathVariable("planet_name" ) String planet_name) throws NotFoundException {
    //    planetService.findAllPlanetName(planet_name);
   // }

    @PatchMapping("/change/{planet_id}")
    public void updatePlanetRecord(@PathVariable("planet_id") int planetId, @Valid @RequestBody UpdatePlanetDTO dto) {
        planetService.changePlanets(planetId, dto.planetName(), dto.radiusKm(), dto.type(), dto.massKg(), dto.orbitalPeriodDays());
    }

    @DeleteMapping("/id/{planet_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("planet_id") int planet_id) throws NotFoundException {
        planetService.deleteById(planet_id);
    }
}
