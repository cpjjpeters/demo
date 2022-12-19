package com.example.demo.instrument.persistence.jpa.entity.mapper;

import com.example.demo.instrument.domain.model.Instrument;
import com.example.demo.instrument.persistence.jpa.entity.InstrumentJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("InstrumentJpaDaoMapper")
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.WARN)
public interface InstrumentJpaDaoMapper {

    InstrumentJpaEntity modelToJpaEntity(Instrument instrument);

    Instrument jpaEntityToModel(InstrumentJpaEntity instrumentJpaEntity);
}
