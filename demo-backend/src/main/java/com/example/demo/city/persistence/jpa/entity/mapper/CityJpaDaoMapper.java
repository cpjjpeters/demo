package com.example.demo.city.persistence.jpa.entity.mapper;

import com.example.demo.city.persistence.jpa.entity.CityJpaEntity;
import com.example.demo.city.domain.model.City;
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
