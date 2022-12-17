package com.example.demo.city.web.in;

import com.example.demo.city.domain.model.City;
import com.example.demo.city.persistence.jpa.CityJpaPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/cities")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityJpaPersistenceService cityJpaPersistenceService;

    public CityController(CityJpaPersistenceService cityJpaPersistenceService) {
        this.cityJpaPersistenceService = cityJpaPersistenceService;
    }

    @GetMapping
    public String displayCities(Model model){
        log.debug("displayCities");
        List<City> cities = cityJpaPersistenceService.findAll();

        model.addAttribute("cities", cities);
        return "cities/list-cities";
    }

    @GetMapping("/new")
    public String displayCityForm(Model model) {
        City aCity = new City();
        model.addAttribute("city", aCity);
        return "cities/new-city";
    }

    @PostMapping("/save")
    public String createCity(City city, Model model) {
        log.debug("handle saving to DB");

        cityJpaPersistenceService.save(city);
        return "redirect:/cities";  // going up to GetMapping slash new
    }


}
