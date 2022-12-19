package com.example.demo.instrument.persistence.jpa;


import com.example.demo.instrument.domain.model.Instrument;
import com.example.demo.instrument.persistence.InstrumentPersistenceFacade;
import com.example.demo.instrument.persistence.jpa.entity.InstrumentJpaEntity;
import com.example.demo.instrument.persistence.jpa.entity.mapper.InstrumentJpaDaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InstrumentJpaPersistenceService implements InstrumentPersistenceFacade {

    private final InstrumentJpaRepository instrumentJpaRepository;

    @Qualifier("InstrumentJpaDaoMapper")
    private final InstrumentJpaDaoMapper instrumentJpaDaoMapper;


    public InstrumentJpaPersistenceService(InstrumentJpaRepository instrumentJpaRepository, InstrumentJpaDaoMapper instrumentJpaDaoMapper) {
        this.instrumentJpaRepository = instrumentJpaRepository;
        this.instrumentJpaDaoMapper = instrumentJpaDaoMapper;
    }


    @Override
    public Instrument save(Instrument instrument) {
        final InstrumentJpaEntity instrumentJpaEntity = this.instrumentJpaRepository.save(instrumentJpaDaoMapper.modelToJpaEntity(instrument));
        return this.instrumentJpaDaoMapper.jpaEntityToModel(instrumentJpaEntity);
    }

    @Override
    public List<Instrument> findAll(Sort id) {
        Sort sortOrder = Sort.by("id").descending();
        List<Instrument> pagedResult = instrumentJpaRepository.findAll(sortOrder)
                .stream().map(this.instrumentJpaDaoMapper::jpaEntityToModel).collect(Collectors.toList());
        return pagedResult;
    }

    @Override
    public Optional<Instrument> findById(Long id) {
        return this.instrumentJpaRepository.findById(id)
                .flatMap(InstrumentJpaEntity -> Optional.of(this.instrumentJpaDaoMapper.jpaEntityToModel(InstrumentJpaEntity)));
    }

    @Override
    public void deleteById(Long id) {
        this.instrumentJpaRepository.deleteById(id);
    }
}
