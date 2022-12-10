package com.example.demo.city.persistence.jpa.entity;

/* carlpeters created on 15/11/2022 inside the package - be.ipeters.crudapplication.entities */

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "CITY")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CityJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name="POPULATION")
    private int population;

    public CityJpaEntity(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public CityJpaEntity(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public CityJpaEntity() {

    }

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
}
