package com.example.demo.stad.domain;

import com.example.demo.stad.persistance.entity.StadJpaEntity;
import com.example.demo.stad.repository.StadJpaPersistenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/* carlpeters created on 17/12/2022 inside the package - com.example.demo.stad.domain.model */
@Slf4j
@Service
public class StadService {

    private final StadJpaPersistenceRepository repository;


    public StadService(StadJpaPersistenceRepository repository) {
        this.repository = repository;
    }

    public List<StadJpaEntity> findAll() {
        return this.repository.findAll();
    }


    public void save(StadJpaEntity stad) {
        this.repository.save(stad);
    }
}
