package com.example.demo.stad.controller;

import com.example.demo.stad.persistance.entity.StadJpaEntity;
import com.example.demo.stad.repository.StadJpaPersistenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/* carlpeters created on 02/12/2022 inside the package - com.example.demo.stad.controller */
@Slf4j
//@Controller
//@RequestMapping(value = "/steden")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class StadEntityController {

    private final StadJpaPersistenceRepository stadRepository;

    public StadEntityController(StadJpaPersistenceRepository stadRepository) {
        this.stadRepository = stadRepository;
    }

    @GetMapping({"","/", "/all"})
    public String displaySteden(Model model) {
        log.debug("displaySteden");
        List<StadJpaEntity> steden = stadRepository.findAll();

        model.addAttribute("steden", steden);
        return "steden/list-steden";
    }


    @GetMapping("/new")
    public String displayCityForm(Model model) {
        log.debug("displayCityForm");
        StadJpaEntity aStad = new StadJpaEntity();
        model.addAttribute("stad", aStad);
        return "steden/new-stad";
    }

    @PostMapping("/save")
    public String createStad(StadJpaEntity stad, Model model) {
        log.debug("handle saving StadJpaEntity to DB");

        stadRepository.save(stad);

        return "redirect:/steden";  // going up to GetMapping slash new
    }
}
