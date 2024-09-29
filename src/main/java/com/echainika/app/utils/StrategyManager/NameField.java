package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.utils.FieldStrategy;

import java.util.List;
import java.util.function.Consumer;

public class NameField extends FieldStrategy {
    public NameField(String fieldName) {
        super(fieldName);
    }

    @Override
    public void set(Integer rowNumber, String cellValue, List<Error> errorList, CandidateRequest candidateRequest) {
        ValidationResult validationResult = validate(cellValue);
        if (validationResult.getIsValid()) {
            candidateRequest.setName(cellValue);
        } else {
            errorList.add(Error.builder().error(validationResult.getError()).rowNumber(rowNumber).build());
        }
    }
}
