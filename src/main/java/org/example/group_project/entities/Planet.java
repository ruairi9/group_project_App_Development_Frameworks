package org.example.group_project.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="planets")
public class Planet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int planet_id;
    private String planet_name;
    private int radius_km;
    private String type;
    private double mass_kg;
    private int orbital_period_days;

}
