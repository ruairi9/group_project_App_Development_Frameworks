package org.example.group_project.repositories;

import org.example.group_project.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Planet p WHERE p.planet_id = :id")
    int deleteById(@Param("id") int id);
}
