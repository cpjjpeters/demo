package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityJpaPersistenceService implements CityPersistenceFacade {
    private final CityJpaRepository cityJpaRepository;
    @Qualifier("CityJpaDaoMapper")
    private final CityJpaDaoMapper cityJpaDaoMapper;


    public CityJpaPersistenceService(CityJpaRepository cityJpaRepository, CityJpaDaoMapper cityJpaDaoMapper) {
        this.cityJpaRepository = cityJpaRepository;
        this.cityJpaDaoMapper = cityJpaDaoMapper;
    }

    @Override
    public City save(City city) {
        final CityJpaEntity cityJpaEntity = this.cityJpaRepository.save(cityJpaDaoMapper.modelToJpaEntity(city));
//        log.debug("City JPA = {}", cityJpaEntity);
        return this.cityJpaDaoMapper.jpaEntityToModel(cityJpaEntity);
    }

    public List<City> findAll() {
        return this.cityJpaRepository.findAll()
                .stream()
                .map(this.cityJpaDaoMapper::jpaEntityToModel).collect(Collectors.toList());
    }

    public void deleteAll() {
        this.cityJpaRepository.deleteAll();
    }
}
