package com.example.demo.common.web.in.mapper;


import org.mapstruct.Mapper;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper(componentModel = "spring")
public class JsonNullableMapper {

    public <T> JsonNullable<T> mapObjectToJsonNullable(T t) {
        return t != null ? JsonNullable.of(t) : JsonNullable.undefined();
    };

    public <T> T mapJsonNullableToObject(JsonNullable<T> t) {
        if (t.isPresent()) {
            return t.get();
        }
        return null;
    };

}
