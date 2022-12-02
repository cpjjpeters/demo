package com.example.demo.stad.controller;

import com.example.demo.stad.persistance.entity.StadJpaEntity;
import com.example.demo.stad.repository.StadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/* carlpeters created on 02/12/2022 inside the package - com.example.demo.stad.controller */
@Slf4j
@Controller
@RequestMapping(value = "/steden")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class StadEntityController {

    private final StadRepository stadRepository;

    public StadEntityController(StadRepository stadRepository) {
        this.stadRepository = stadRepository;
    }

    @GetMapping({"/", "/all"})
    public List<StadJpaEntity> getAllSteden() {
        log.debug("getAllSteden");
        return stadRepository.findAll();

    }

}
