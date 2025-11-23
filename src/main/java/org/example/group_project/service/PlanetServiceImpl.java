package org.example.group_project.service;

import org.example.group_project.dtos.PlanetDTO;
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
    public void deleteById(int id) {
        int rowsDeleted = planetRepository.deleteById(id);
        if(rowsDeleted== 0) {
            throw new NotFoundException("Planet with id " + id + " was not found");//to do need to make the Exception code
        }
    }
}
