package org.example.group_project.services;

import org.example.group_project.dtos.MoonDTO;
import org.example.group_project.dtos.MoonMapper;
import org.example.group_project.entities.Moon;
import org.example.group_project.repositories.MoonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        moonRepository.deleteById((long) id);
    }

    @Override
    public Moon save(Moon moon) {
        return moonRepository.save(moon);
    }
}
