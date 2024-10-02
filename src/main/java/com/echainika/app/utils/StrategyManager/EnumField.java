package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.enums.Gender;
import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.model.enums.OccupationType;
import com.echainika.app.utils.FieldStrategy;

import java.util.function.BiConsumer;

import static com.echainika.app.utils.FieldUtil.*;

public class EnumField extends FieldStrategy {
    public EnumField(String fieldName, BiConsumer<String, CandidateRequest> setter) {
        super(fieldName, setter);
    }

    @Override
    public ValidationResult validate(String cellValue) {
        try {
            switch (getFieldName()) {
                case MARITAL_STATUS:
                    MaritalStatus.valueOf(cellValue.toUpperCase());
                    break;
                case OCCUPATION_TYPE, PARENT_OCCUPATION_TYPE:
                    OccupationType.valueOf(cellValue.toUpperCase());
                    break;
                case GENDER:
                    Gender.valueOf(cellValue.toUpperCase());
                    break;
                default:
                    break;
            }
            return new ValidationResult(true, "");
        } catch (NullPointerException ne) {
            return  new ValidationResult(false,super.getFieldName() + " is absent");
        } catch (IllegalArgumentException ie) {
            return  new ValidationResult(false,super.getFieldName() + " does not match with any values");
        }
    }
}
