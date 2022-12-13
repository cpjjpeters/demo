package com.example.demo.city.persistence.jpa;

import com.example.demo.city.persistence.jpa.entity.CityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Long> {
    CityJpaEntity findCityById(long id);

//    @Override
//    public List<CityJpaEntity> findAll();

}
