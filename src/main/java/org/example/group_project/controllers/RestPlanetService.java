package org.example.group_project.controllers;

import jakarta.validation.Valid;
import org.example.group_project.dtos.PlanetCreateDTO;
import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.dtos.PlanetMappers;
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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO createPlanet(@Valid @RequestBody PlanetCreateDTO planetCreateDTO) {
        Planet newPlanet = PlanetMappers.maptoEntity(planetCreateDTO);
        newPlanet = planetService.save(newPlanet);
        return PlanetMappers.mapPlanettoPlanetDTO(newPlanet);
    }

    @DeleteMapping("/{planet_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable("planet_id") int planet_id) throws NotFoundException {
        planetService.deleteById(planet_id);
    }
}
