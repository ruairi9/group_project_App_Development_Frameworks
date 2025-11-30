package org.example.group_project.services;

import org.example.group_project.dtos.MoonDTO;
import org.example.group_project.entities.Moon;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface MoonService {
    List<MoonDTO> findAll();
    void deleteById(int id);
    Moon save(Moon moon);
}

