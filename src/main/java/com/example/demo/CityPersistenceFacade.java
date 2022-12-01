package com.example.demo;

import java.util.List;

public interface CityPersistenceFacade {

    City save(City city);

    List<City> findAll();

}
