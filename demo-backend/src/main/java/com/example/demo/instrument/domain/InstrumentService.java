package com.example.demo.instrument.domain;

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.instrument.domain.model.Instrument;
import com.example.demo.instrument.persistence.InstrumentPersistenceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstrumentService {
    private final InstrumentPersistenceFacade instrumentPersistenceFacade;


    public InstrumentService(InstrumentPersistenceFacade instrumentPersistenceFacade) {
        this.instrumentPersistenceFacade = instrumentPersistenceFacade;
    }

    public List<Instrument> findAll(){
        return this.instrumentPersistenceFacade.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Optional<Instrument> findById(Long id){
        return this.instrumentPersistenceFacade.findById(id);
//                .orElseThrow(new ResourceNotFoundException("Instrument not found"));
    }

    public Instrument save(Instrument instrument) {
        return this.instrumentPersistenceFacade.save(instrument);
    }

    public void deleteById(Long id) {
        Optional<Instrument> instrument = this.instrumentPersistenceFacade.findById(id);
        if(instrument.isPresent()){
            this.instrumentPersistenceFacade.deleteById(id);
        }
    }
}
