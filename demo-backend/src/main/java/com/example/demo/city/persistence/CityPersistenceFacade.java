package com.example.demo.city.persistence;

import com.example.demo.city.domain.model.City;

import java.util.List;

public interface CityPersistenceFacade {

    City save(City city);

    List<City> findAll();

    City findCityById(long id);
}
