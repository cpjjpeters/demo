package com.example.demo.instrument.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {

    private Long id;
    private String name;
    private String isinCode;
    private String initialMarket;
    private String currency;


}
