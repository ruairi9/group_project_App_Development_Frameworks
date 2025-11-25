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
    public void deleteById(int planet_id) {
        int rowsDeleted = planetRepository.deleteById(planet_id);
        if(rowsDeleted== 0) {
            throw new NotFoundException("Planet with id " + planet_id + " was not found");
        }
    }

    @Override
    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }
}
