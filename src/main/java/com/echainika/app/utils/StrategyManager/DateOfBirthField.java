package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.utils.FieldStrategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateOfBirthField extends FieldStrategy {
    public DateOfBirthField(String fieldName) {
        super(fieldName);
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

    @Override
    public void set(Integer rowNumber, String cellValue, List<Error> errorList, CandidateRequest candidateRequest) {
        ValidationResult validationResult = validate(cellValue);
        if (validationResult.getIsValid()) {
            candidateRequest.setDateOfBirth(LocalDate.parse(cellValue, DateTimeFormatter.ISO_LOCAL_DATE));
        } else {
            errorList.add(Error.builder().error(validationResult.getError()).rowNumber(rowNumber).build());
        }
    }
}
