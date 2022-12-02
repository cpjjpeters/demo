package com.example.demo.stad.repository;

import com.example.demo.stad.persistance.entity.StadJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadRepository extends JpaRepository<StadJpaEntity, Long> {
}
