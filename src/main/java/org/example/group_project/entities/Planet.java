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
    private int planetId;
    @Column(name = "planet_name")
    private String planetName;
    private int radiusKm;
    private String type;
    private double massKg;
    private int orbitalPeriodDays;

}
