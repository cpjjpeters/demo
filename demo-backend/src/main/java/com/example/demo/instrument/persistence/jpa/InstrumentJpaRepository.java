package com.example.demo.instrument.persistence.jpa;

import com.example.demo.instrument.persistence.jpa.entity.InstrumentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentJpaRepository extends JpaRepository<InstrumentJpaEntity, Long> {

    Optional<InstrumentJpaEntity> findById(Long id);

}
