package com.example.demo.city.persistence.jpa;

import com.example.demo.city.persistence.jpa.entity.CityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Long> {

//    @Override
//    public List<CityJpaEntity> findAll();

}
