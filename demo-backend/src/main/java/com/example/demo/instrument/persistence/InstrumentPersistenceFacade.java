package com.example.demo.instrument.persistence;

import com.example.demo.instrument.domain.model.Instrument;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface InstrumentPersistenceFacade {

    Instrument save(Instrument instrument);

    List<Instrument> findAll(Sort id);

    Optional<Instrument> findById(Long id);

    void deleteById(Long id);


}
