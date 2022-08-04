package com.example.carsystemproject.model.convert;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String>  {

    @Override
    public String convertToDatabaseColumn(Boolean aboolean) {
        return (aboolean != null && aboolean) ? "M" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "F".equalsIgnoreCase(s);
    }
}
