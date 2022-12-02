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
}
