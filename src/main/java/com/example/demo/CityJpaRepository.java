package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<CityJpaEntity, Long> {

//    @Override
//    public List<CityJpaEntity> findAll();

}
