package com.example.demo.city.web.in.mapper;

/* carlpeters created on 10/12/2022 inside the package - com.example.demo.city.web.in.mapper */

import com.example.demo.city.domain.model.City;
import com.example.demo.common.web.in.mapper.BaseMapStructConfig;
import com.example.demo.demo_api.model.CityResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = BaseMapStructConfig.class)
public interface CityDtoMapper {

    CityResource mapDomainToResource(City city);
}
