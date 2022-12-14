package com.example.demo.common.web.in.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(uses = { UUIDMapper.class, DateMapper.class,
        JsonNullableMapper.class }, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BaseMapStructConfig {
}
