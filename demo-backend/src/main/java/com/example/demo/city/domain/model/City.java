package com.example.demo.city.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private Long id;
    private String name;

    private String urbanisation;

    private String province;

    private Double surface;
    private int population;




    public City() {
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public City(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

}
