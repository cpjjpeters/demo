package com.example.demo.common.web.in.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

/* carlpeters created on 11/12/2022 inside the package - com.example.demo.common.web.in.mapper */
@Mapper(componentModel = "spring")
public class DateMapper {
    public OffsetDateTime map(Instant instant) {
        return instant != null ? OffsetDateTime.ofInstant(instant, ZoneOffset.UTC) : null;

    }

    public Instant map(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toInstant() : null;
    }

    public LocalDate mapToDate(String stringValue) throws IllegalArgumentException {
        if (StringUtils.isEmpty(stringValue)) {
            return null;
        }
        try {
            return LocalDate.parse(stringValue);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public String mapToString(LocalDate updatedSystemDate) {
        return updatedSystemDate == null ? null : updatedSystemDate.toString();
    }

}
