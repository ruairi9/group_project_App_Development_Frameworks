package org.example.group_project.controllers;

import org.example.group_project.dtos.PlanetDTO;
import org.example.group_project.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestService {

    private PlanetService planetService;

    @GetMapping("/planets")
    List<PlanetDTO> findAllCities(){
        return planetService.findAll();
    }

    @DeleteMapping("/planets/{planet_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlanetById(@PathVariable int planet_id){
        planetService.deleteById(planet_id);
    }
}
