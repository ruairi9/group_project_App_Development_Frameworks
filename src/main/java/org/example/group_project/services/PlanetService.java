package org.example.group_project.services;

import org.example.group_project.dtos.PlanetDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface PlanetService {
    List<PlanetDTO> findAll();
    void deleteById(int id);
}
