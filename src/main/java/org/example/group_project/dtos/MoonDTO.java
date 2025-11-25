package org.example.group_project.dtos;

import lombok.Getter;
import lombok.Setter;

public class MoonDTO {
    @Setter
    @Getter
    private int planetId;
    @Setter
    @Getter
    private Long moonId;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Double diameterKm;
    @Setter
    @Getter
    private Double orbitalPeriodDays;
    @Getter
    @Setter
    private String planetName;



}
