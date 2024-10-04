package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.utils.FieldStrategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.BiConsumer;

public class DateField extends FieldStrategy {
    public DateField(String fieldName, BiConsumer<String, CandidateData> setter) {
        super(fieldName, setter);
    }

    @Override
    public ValidationResult validate(String cellValue) {
        try {
            LocalDate.parse(cellValue, DateTimeFormatter.ISO_LOCAL_DATE);
            return new ValidationResult(true, "");
        } catch (DateTimeParseException de) {
            return new ValidationResult(false, super.getFieldName() + " wrong format");
        } catch (NullPointerException ne) {
            return new ValidationResult(false, super.getFieldName() + "is absent");
        }
    }
}
