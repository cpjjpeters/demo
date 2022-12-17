package com.example.demo.ui;
import com.example.demo.stad.domain.StadService;
import com.example.demo.stad.domain.model.Stad;
import com.example.demo.stad.persistance.entity.StadJpaDaoMapper;
import com.example.demo.stad.persistance.entity.StadJpaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/* carlpeters created on 17/12/2022 inside the package - com.example.demo.ui */
@Slf4j
@Controller
@RequestMapping(value = "/steden")//, produces = MediaType.APPLICATION_JSON_VALUE)
public class StadUIController {

    private final StadService stadService;
    private final StadJpaDaoMapper stadJpaDaoMapper;

    public StadUIController(StadService stadService, StadJpaDaoMapper stadJpaDaoMapper) {
        this.stadService = stadService;
        this.stadJpaDaoMapper = stadJpaDaoMapper;
    }


    @GetMapping({"","/", "/all"})
    public String displaySteden(Model model) {
        log.debug("displaySteden");
        List<Stad> steden = stadService.findAll()
                .stream()
                .map(this.stadJpaDaoMapper::jpaEntityToModel)
                .collect(Collectors.toList());

        model.addAttribute("steden", steden);
        return "steden/list-steden";
    }


    @GetMapping("/new")
    public String displayCityForm(Model model) {
        log.debug("displayCityForm");
        Stad aStad = new Stad();
        model.addAttribute("stad", aStad);
        return "steden/new-stad";
    }

    @PostMapping("/save")
    public String createStad(Stad stad, Model model) {
        log.debug("handle saving Stad to DB");

        stadService.save(this.stadJpaDaoMapper.modelToJpaEntity(stad));

        return "redirect:/steden";  // going up to GetMapping slash new
    }
}
