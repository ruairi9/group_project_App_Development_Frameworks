package org.example.group_project.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "planet_name")
    private String planetName;
    @NotNull(message = "planet radius is required")
    @Positive(message = "planet radius must be positive")
    private int radiusKm;
    @NotNull(message = "planet type is required")
    private String type;
    @NotNull(message = "planet mass is required")
    @Positive(message = "planet mass must be positive")
    private double massKg;
    @NotNull(message = "planet orbital period is required")
    @Positive(message = "planet orbital period must be positive")
    private int orbitalPeriodDays;

}
