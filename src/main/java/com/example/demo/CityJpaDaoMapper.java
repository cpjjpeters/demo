package com.example.demo;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author tersc
 */
@Qualifier("CityJpaDaoMapper")
@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CityJpaDaoMapper {
    CityJpaEntity modelToJpaEntity(City city);

    City jpaEntityToModel(CityJpaEntity cityJpaEntity);
}
