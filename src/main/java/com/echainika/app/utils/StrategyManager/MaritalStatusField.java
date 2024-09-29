package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.utils.FieldStrategy;

import java.util.List;

public class MaritalStatusField extends FieldStrategy {
    public MaritalStatusField(String fieldName) {
        super(fieldName);
    }

    @Override
    public ValidationResult validate(String cellValue) {
        try {
            MaritalStatus.valueOf(cellValue.toUpperCase());
            return new ValidationResult(true, "");
        } catch (NullPointerException ne) {
            return  new ValidationResult(false,super.getFieldName() + " is absent");
        } catch (IllegalArgumentException ie) {
            return  new ValidationResult(false,super.getFieldName() + " does not match with any values");
        }
    }

    @Override
    public void set(Integer rowNumber, String cellValue, List<Error> errorList, CandidateRequest candidateRequest) {
        ValidationResult validationResult = validate(cellValue);
        if (validationResult.getIsValid()) {
            candidateRequest.setMaritalStatus(MaritalStatus.valueOf(cellValue.toUpperCase()));
        } else {
            errorList.add(Error.builder().error(validationResult.getError()).rowNumber(rowNumber).build());
        }
    }
}
