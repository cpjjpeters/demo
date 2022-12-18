package com.example.demo.stad.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stad {
    private Long id;
    private String name;
    private int population;

    public Stad(String name, int population) {
        this.name = name;
        this.population = population;
    }

}
