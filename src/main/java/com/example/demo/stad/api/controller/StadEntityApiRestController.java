package com.example.demo.stad.api.controller;

/* carlpeters created on 02/12/2022 inside the package - com.example.demo.stad.api.controller */

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.stad.persistance.entity.StadJpaEntity;
import com.example.demo.stad.repository.StadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class StadEntityApiRestController {
    private final StadRepository stadRepository;


    public StadEntityApiRestController(StadRepository stadRepository) {
        this.stadRepository = stadRepository;
    }

    @GetMapping("/steden")
    public List<StadJpaEntity> getAllSteden() {
        log.debug("getAllSteden");
        return stadRepository.findAll();

    }

    @GetMapping("/steden/{id}")
    public ResponseEntity<StadJpaEntity> getStadById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {

        log.debug("getStadById");
        StadJpaEntity stadJpaEntity = stadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Stad not found for this id :: " + id));

        return ResponseEntity.ok().body(stadJpaEntity);

    }

    @PostMapping("/steden")
    public StadJpaEntity createStad(@Valid @RequestBody StadJpaEntity stadJpaEntity) {
        return stadRepository.save(stadJpaEntity);
    }

    @PutMapping("/steden/{id}")
    public ResponseEntity<StadJpaEntity> updateStad(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody StadJpaEntity stadDetails) throws ResourceNotFoundException {
        StadJpaEntity stadJpaEntity = stadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StadJpaEntity not found for this id :: " + id));

        stadJpaEntity.setId(stadDetails.getId());
        stadJpaEntity.setName(stadDetails.getName());
        stadJpaEntity.setPopulation(stadDetails.getPopulation());
        final StadJpaEntity updatedStad = stadRepository.save(stadJpaEntity);
        return ResponseEntity.ok(updatedStad);
    }

    @DeleteMapping("/steden/{id}")
    public Map<String, Boolean> deleteStad(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        StadJpaEntity stadJpaEntity = stadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StadJpaEntity not found for this id :: " + id));

        stadRepository.delete(stadJpaEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}