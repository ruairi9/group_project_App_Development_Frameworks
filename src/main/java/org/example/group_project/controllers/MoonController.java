package org.example.group_project.controllers;

import org.example.group_project.dtos.MoonDTO;
import org.example.group_project.entities.Moon;
import org.example.group_project.repositories.MoonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/moons")
public class MoonController {

    private final MoonRepository moonRepository;

    public MoonController(MoonRepository moonRepository) {
        this.moonRepository = moonRepository;
    }

    // api/moons get is used to get the list of the moos
    @GetMapping
    public List<MoonDTO> getAllMoons() {
        return moonRepository.findAll().stream().map(moon -> {
            MoonDTO dto = new MoonDTO();
            dto.setMoonId(moon.getMoonId());
            dto.setName(moon.getName());
            dto.setDiameterKm(moon.getDiameterKm());
            dto.setOrbitalPeriodDays(moon.getOrbitalPeriodDays());
            dto.setPlanetId(moon.getPlanet().getPlanet_id());
            dto.setPlanetName(moon.getPlanet().getPlanet_name());
            return dto;
        }).collect(Collectors.toList());
    }

    // getting the moon by its id  (not sure to use long which i found out is standard but for now ill stick with int)
    @GetMapping("/{id}")
    public MoonDTO getMoonById(@PathVariable int id) {
        Moon moon = moonRepository.findById((long) id) // i had to cast the id to long here as the repository JpaRepository uses long i think for the id which i may change to use long althougher
                .orElseThrow(() -> new RuntimeException("the current moon does nto exist")); //
        MoonDTO dto = new MoonDTO();
        dto.setMoonId(moon.getMoonId());
        dto.setName(moon.getName());
        dto.setDiameterKm(moon.getDiameterKm());
        dto.setOrbitalPeriodDays(moon.getOrbitalPeriodDays());
        dto.setPlanetId(moon.getPlanet().getPlanet_id()); // dont kno why this is saying planet_id instad of just planet id
        dto.setPlanetName(moon.getPlanet().getPlanet_name());
        return dto;
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
}
