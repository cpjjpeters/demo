package com.example.demo.common.web.in.mapper;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.util.UUID;


@Mapper(componentModel = "spring")
public class UUIDMapper {
    public String map(UUID uuid) {
        if (uuid == null) {
            return null;
        }
        return uuid.toString();
    }

    public UUID map(String string) {
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        return UUID.fromString(string);
    }
}
