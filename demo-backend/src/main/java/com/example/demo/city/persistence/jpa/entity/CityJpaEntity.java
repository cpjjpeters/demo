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
    @Column(name="URBANISATION")
    private String urbanisation;

    @Column(name="PROVINCE")
    private String province;

    @Column(name="SURFACE")
    private Double surface;

    @Column(name="POPULATION")
    private int population;

    public CityJpaEntity(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public CityJpaEntity(Long id, String name, String urbanisation, String province, Double surface, int population) {
        this.id = id;
        this.name = name;
        this.urbanisation = urbanisation;
        this.province = province;
        this.surface = surface;
        this.population = population;
    }

    public CityJpaEntity(String name, String urbanisation, String province, Double surface, int population) {
        this.name = name;
        this.urbanisation = urbanisation;
        this.province = province;
        this.surface = surface;
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

    public String getUrbanisation() {
        return urbanisation;
    }

    public void setUrbanisation(String urbanisation) {
        this.urbanisation = urbanisation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
