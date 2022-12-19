package com.example.demo.instrument.api.controller;


import com.example.demo.city.domain.model.City;
import com.example.demo.demo_api.model.CityResource;
import com.example.demo.demo_api.model.InstrumentResource;
import com.example.demo.instrument.domain.InstrumentService;
import com.example.demo.instrument.domain.model.Instrument;
import com.example.demo.instrument.web.in.mapper.InstrumentDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentApiRestController {

    private final InstrumentService instrumentService;
    private final InstrumentDtoMapper instrumentDtoMapper;


    public InstrumentApiRestController(InstrumentService instrumentService, InstrumentDtoMapper instrumentDtoMapper) {
        this.instrumentService = instrumentService;
        this.instrumentDtoMapper = instrumentDtoMapper;
    }

    @GetMapping(value = {"","/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstrumentResource>> findAll(){
        List<Instrument> instruments = instrumentService.findAll();
        if(instruments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(instruments.stream()
                .map(this.instrumentDtoMapper::mapDomainToResource)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstrumentResource> findById(@PathVariable("id") @Min(value = 1, message = "Invalid id value.") long id){
        log.debug("findById {}", id);
        return ResponseEntity.ok(this.instrumentDtoMapper.mapDomainToResource(this.instrumentService.findById(id).orElse(new Instrument())));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.instrumentService.deleteById(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<InstrumentResource> save(@RequestBody Instrument instrument){
        Instrument instrument2BeSaved = instrumentService.save(instrument);
        return ResponseEntity.ok(instrumentDtoMapper.mapDomainToResource(instrument2BeSaved));
    }
}
