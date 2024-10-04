package com.echainika.app.utils;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.CandidateData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.BiConsumer;

@AllArgsConstructor
@Getter
public abstract class FieldStrategy {
    private String fieldName;

    private BiConsumer<String, CandidateData> setter;

    public ValidationResult validate(String cellValue) {
        return cellValue != null ? new ValidationResult(true, "") : new ValidationResult(false, fieldName + "is absent");
    }

    public void set(Integer rowNumber, String cellValue, List<Error> errorList, CandidateData candidateData) {
        ValidationResult validationResult = validate(cellValue);
        if (validationResult.getIsValid()) {
            setter.accept(cellValue, candidateData);
        } else {
            errorList.add(Error.builder().error(validationResult.getError()).rowNumber(rowNumber).build());
        }
    }

    @AllArgsConstructor
    @Getter
    public static class ValidationResult {
        private Boolean isValid;
        private String error;
    }
}
