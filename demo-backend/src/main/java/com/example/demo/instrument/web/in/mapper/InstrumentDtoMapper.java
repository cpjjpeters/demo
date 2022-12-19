package com.example.demo.instrument.web.in.mapper;

import com.example.demo.common.web.in.mapper.BaseMapStructConfig;
import com.example.demo.demo_api.model.InstrumentResource;
import com.example.demo.instrument.domain.model.Instrument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = BaseMapStructConfig.class)
public interface InstrumentDtoMapper {

    InstrumentResource mapDomainToResource(Instrument instrument);
}
