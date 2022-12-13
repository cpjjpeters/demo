package com.example.demo.stad.persistance.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* carlpeters created on 01/12/2022 inside the package - com.example.demo.stad.persistance.entity */
@Entity
public class StadJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "POPULATION")
    private int population;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public StadJpaEntity() {
    }

    public StadJpaEntity(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public StadJpaEntity(String name, int population) {
        this.name = name;
        this.population = population;
    }
}
