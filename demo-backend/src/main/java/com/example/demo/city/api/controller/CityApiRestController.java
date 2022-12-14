package com.example.demo.city.api.controller;

import com.example.demo.city.domain.CityService;
import com.example.demo.city.domain.model.City;
import com.example.demo.city.web.in.mapper.CityDtoMapper;
import com.example.demo.demo_api.model.CityResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api/v1/cities")
public class CityApiRestController {
    private final CityService cityService;
    private final CityDtoMapper cityDtoMapper;

    public CityApiRestController(CityService cityService, CityDtoMapper cityDtoMapper) {
        this.cityService = cityService;
        this.cityDtoMapper = cityDtoMapper;
    }

    @GetMapping(value = {"/",""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResource>> findAllCities(){
        log.debug("findAllCities");
        List<City> cities = cityService.findAllCities();
        if(cities.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cities.stream()
                .map(this.cityDtoMapper::mapDomainToResource)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResource> findCityById(@PathVariable("id") @Min(value = 1, message = "Invalid id value.") long id){
        log.debug("findCityById {}", id);
        return ResponseEntity.ok(this.cityDtoMapper.mapDomainToResource(this.cityService.findCityById(id)));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CityResource> save(@RequestBody City city){
        log.debug("save City");
        City city2BeSaved = cityService.save(city);
        return ResponseEntity.ok(cityDtoMapper.mapDomainToResource(city2BeSaved));
    }

}
