package com.jb.CouponSystem.data;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This file is a part of Coupon-System project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return attribute == null ? null : Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : dbData.toLocalDate();
    }
}
