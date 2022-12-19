package com.example.demo.instrument.persistence.jpa.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "INSTRUMENT")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InstrumentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ISIN")
    private String isinCode;

    @Column(name = "INITIAL_MARKET")
    private String initialMarket;

    @Column(name = "CURRENCY")
    private String currency;


    public InstrumentJpaEntity(Long id, String name, String isinCode, String initialMarket, String currency) {
        this.id = id;
        this.name = name;
        this.isinCode = isinCode;
        this.initialMarket = initialMarket;
        this.currency = currency;
    }

    public InstrumentJpaEntity(){

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

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public String getInitialMarket() {
        return initialMarket;
    }

    public void setInitialMarket(String initialMarket) {
        this.initialMarket = initialMarket;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
