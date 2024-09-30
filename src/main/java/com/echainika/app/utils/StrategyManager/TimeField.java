package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.utils.FieldStrategy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.BiConsumer;

public class TimeField extends FieldStrategy {
    public TimeField(String fieldName, BiConsumer<String, CandidateRequest> setter) {
        super(fieldName, setter);
    }

    @Override
    public ValidationResult validate(String cellValue) {
        try {
            LocalTime.parse(cellValue, DateTimeFormatter.ISO_LOCAL_TIME);
            return new ValidationResult(true, "");
        } catch (DateTimeParseException de) {
            return new ValidationResult(false, super.getFieldName() + " wrong format");
        } catch (NullPointerException ne) {
            return new ValidationResult(false, super.getFieldName() + "is absent");
        }
    }
}
