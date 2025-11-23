package org.example.group_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="moons")
public class Moon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int moon_id;
    private String moon_name;
    private int diameter_km;
    private int orbital_period_days;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="planet_id")
    private Planet planet_id;
}
