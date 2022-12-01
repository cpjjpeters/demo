package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/cities")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

//    @Autowired
//    CityJpaRepository cityJpaRepository;
//    @Autowired
//    CityJpaDaoMapper cityJpaDaoMapper;

    private final CityJpaPersistenceService cityJpaPersistenceService;

    public CityController(CityJpaPersistenceService cityJpaPersistenceService) {
        this.cityJpaPersistenceService = cityJpaPersistenceService;
    }

    @GetMapping
    public String displayCities(Model model){
//        log.debug("displayCities");
//        List<City> cities = cityJpaPersistenceService.findAll();

//        model.addAttribute("cities", cities);
        return "cities/list-cities";
    }

//    @GetMapping("/new")
//    public String displayCityForm(Model model) {
//        Stad aCity = new Stad();
//        model.addAttribute("city", aCity);
//        return "new-city";
//    }
//
//    @PostMapping("/save")
//    public String createCity(Stad city, Model model) {
//        log.debug("handle saving to DB");
////        cityJpaRepository.save(cityJpaDaoMapper.modelToJpaEntity(city));
//
//        cityJpaPersistenceService.save(city);
//        return "redirect:/new";  // going up to GetMapping slash new
//    }

//    @GetMapping(value="/welkom")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        log.debug("Welcome!");
//        model.addAttribute("name", name);
//        return "welcome";
//    }
//
//    @GetMapping(value = {"/indeks", "all"})
//    public String index(Model model) {
//        log.debug("getmapping slash");
//        return "index";
//    }

//    @GetMapping(value="/steden")
//    public ModelAndView showCities() {
//        log.debug("getmapping slash cities");
//        var cities = cityJpaPersistenceService.findAll();
//
//        var params = new HashMap<String, Object>();
//        params.put("cities", cities);
//
//        return new ModelAndView("showCities", params);
//    }
}
