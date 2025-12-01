package org.example.group_project.controllers;

import jakarta.validation.Valid;
import org.example.group_project.dtos.MoonCreateDTO;
import org.example.group_project.dtos.MoonDTO;
import org.example.group_project.dtos.MoonMapper;
import org.example.group_project.entities.Moon;
import org.example.group_project.entities.Planet;
import org.example.group_project.repositories.MoonRepository;
import org.example.group_project.repositories.PlanetRepository;
import org.example.group_project.services.MoonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moons")
public class RestServiceMoon {

    private final MoonRepository moonRepository;
    private final MoonService moonService;
    private final PlanetRepository planetRepository;


    public RestServiceMoon(MoonRepository moonRepository, MoonService moonService , PlanetRepository planetRepository) {
        this.moonRepository = moonRepository;
        this.moonService = moonService;
        this.planetRepository = planetRepository;
    }

    // /moons get is used to get the list of the moos
    @GetMapping
    public List<MoonDTO> getAllMoons() {
        return moonRepository.findAll().stream()
                .map(moon -> new MoonDTO(
                        moon.getMoonId(),
                        moon.getName(),
                        moon.getDiameterKm(),
                        moon.getOrbitalPeriodDays(),
                        moon.getPlanet().getPlanetId(),
                        moon.getPlanet().getPlanetName()
                ))
                .toList();
    }

    // getting the moon by its id  (not sure to use long which i found out is standard but for now ill stick with int)
    @GetMapping("/{id}")
    public MoonDTO getMoonById(@PathVariable Long id) {
        Moon moon = moonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moon does not exist"));
        return new MoonDTO(
                moon.getMoonId(),
                moon.getName(),
                moon.getDiameterKm(),
                moon.getOrbitalPeriodDays(),
                moon.getPlanet().getPlanetId(),
                moon.getPlanet().getPlanetName()
        );
    }

    //Deletes the moon using its id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoon(@PathVariable Long id) {
        if (!moonRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        moonRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public MoonDTO createMoon(@Valid @RequestBody MoonCreateDTO moonCreateDTO) {
        Planet planet = planetRepository.findById(Math.toIntExact(moonCreateDTO.planetId()))
                .orElseThrow(() -> new RuntimeException("Planet not found"));
        Moon newMoon = MoonMapper.mapToEntity(moonCreateDTO, planet);

        newMoon = moonService.save(newMoon);
        return MoonMapper.mapMoonToMoonDTO(newMoon);
    }

    @GetMapping("/planet/{planetName}")
    public List<MoonDTO> getMoonsByPlanetName(@PathVariable String planetName) {
        return moonRepository.findByPlanet_PlanetName(planetName).stream()
                .map(MoonMapper::mapMoonToMoonDTO)
                .toList();}


    @GetMapping("/count/planet/{planetId}")
    public Map<String, Object> countMoonsByPlanet(@PathVariable Long planetId) {
        long count = moonRepository.countByPlanet_PlanetId(planetId);
        return Map.of(
                "planetId", planetId,
                "moonCount", count
        );
    }


}
