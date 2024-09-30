package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.utils.FieldStrategy;

import java.util.function.BiConsumer;

public class MaritalEnumField extends FieldStrategy {
    public MaritalEnumField(String fieldName, BiConsumer<String, CandidateRequest> setter) {
        super(fieldName, setter);
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
}
