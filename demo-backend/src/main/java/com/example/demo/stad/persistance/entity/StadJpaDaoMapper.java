package com.example.demo.stad.persistance.entity;

import com.example.demo.stad.domain.model.Stad;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("StadJpaDaoMapper")
@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.WARN)
public interface StadJpaDaoMapper {

    StadJpaEntity modelToJpaEntity(Stad stad);

    Stad jpaEntityToModel(StadJpaEntity stadJpaEntity);
}
