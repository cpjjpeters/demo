package com.example.demo.city.domain;

import com.example.demo.city.domain.model.City;
import com.example.demo.city.persistence.CityPersistenceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/* carlpeters created on 13/12/2022 inside the package - com.example.demo.city.domain.model */
@Slf4j
@Service
public class CityService {
    private final CityPersistenceFacade cityPersistenceFacade;

    public CityService(CityPersistenceFacade cityPersistenceFacade) {
        this.cityPersistenceFacade = cityPersistenceFacade;
    }

    public List<City> findAllCities(){
        log.debug("return this.cityPersistenceFacade.findAll();");
        return this.cityPersistenceFacade.findAll();
    }

    public City findCityById(long id) {
        log.debug("return this.cityPersistenceFacade.findCityById(id);");
        return this.cityPersistenceFacade.findCityById(id);
    }

    public City save(City city) {
        log.debug("return this.cityPersistenceFacade.save(city);");
        return this.cityPersistenceFacade.save(city);
    }
}
