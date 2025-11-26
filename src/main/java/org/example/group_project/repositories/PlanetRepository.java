package org.example.group_project.repositories;

import org.example.group_project.entities.Planet;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Planet p WHERE p.planetId = :planet_id")
    int deleteById(@Param("planet_id") int planetId);

    Optional<Planet> findByPlanetName(String planetName);

    Optional<Planet> findByRadiusKm(int radiusKm);

    List<Planet> findByType(String type);

    Optional<Planet> findByMassKg(double massKg);

    Optional<Planet> findByOrbitalPeriodDays(int orbitalPeriodDays);

    @Query("SELECT p.planetId FROM Planet p WHERE p.planetId IS NOT NULL")
    List<Integer> findAllPlanetIdOnly();


    @Query("SELECT p.planetName FROM Planet p WHERE p.planetName IS NOT NULL")
    List<String> findAllPlanetNameOnly();

    @Query("SELECT p.radiusKm FROM Planet p WHERE p.radiusKm IS NOT NULL")
    List<Integer> findAllPlanetRadiusOnly();

    @Query("SELECT p.type FROM Planet p WHERE p.type IS NOT NULL")
    List<String> findAllPlanetTypeOnly();

    @Query("SELECT p.massKg FROM Planet p WHERE p.massKg IS NOT NULL")
    List<Double> findAllPlanetMassOnly();

    @Query("SELECT p.orbitalPeriodDays FROM Planet p WHERE p.orbitalPeriodDays IS NOT NULL")
    List<Integer> findAllPlanetOrbitalPeriodDaysOnly();
}
