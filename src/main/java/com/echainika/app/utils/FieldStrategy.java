package com.echainika.app.utils;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Getter
public abstract class FieldStrategy {
    private String fieldName;

    public ValidationResult validate(String cellValue) {
        return cellValue != null ? new ValidationResult(true, "") : new ValidationResult(false, fieldName + "is absent");
    }

    public void set(Integer rowNumber, String cellValue, List<Error> errorList, CandidateRequest candidateRequest) {}

    @AllArgsConstructor
    @Getter
    public static class ValidationResult {
        private Boolean isValid;
        private String error;
    }
}
