package org.example.group_project.services;

import org.example.group_project.dtos.MoonDTO;
import org.example.group_project.dtos.MoonMapper;
import org.example.group_project.entities.Moon;
import org.example.group_project.exceptions.DatabaseException;
import org.example.group_project.exceptions.DuplicateResourceException;
import org.example.group_project.exceptions.NotFoundException;
import org.example.group_project.repositories.MoonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;

    public MoonServiceImpl(MoonRepository moonRepository) {
        this.moonRepository = moonRepository;
    }

    @Override
    public List<MoonDTO> findAll() {
        return moonRepository.findAll().stream()
                .map(MoonMapper::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        if (!moonRepository.existsById((long) id)) {
            throw new NotFoundException("Moon with id " + id + " was not found");
        }
        moonRepository.deleteById((long) id);
    }

    @Override
    public Moon save(Moon moon) {
        if (!moonRepository.findByPlanet_PlanetName(moon.getName()).isEmpty()) {
            throw new DuplicateResourceException(
                    "Moon with name " + moon.getName() + " already exists"
            );
        }
        return Optional.of(moonRepository.save(moon))
                .orElseThrow(() -> new DatabaseException("Failed to save moon"));
    }
}
