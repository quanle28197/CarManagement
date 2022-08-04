package com.example.carsystemproject.model.convert;

import javax.persistence.AttributeConverter;
import java.sql.Time;
import java.time.LocalTime;

public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {
    @Override
    public Time convertToDatabaseColumn(LocalTime localTime) {
        return localTime == null ? null : Time.valueOf(localTime);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time) {
        return time == null ? null : time.toLocalTime();
    }
}
