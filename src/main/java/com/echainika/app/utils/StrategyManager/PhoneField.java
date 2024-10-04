package com.echainika.app.utils.StrategyManager;
import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.utils.FieldStrategy;


import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneField extends FieldStrategy {

    public PhoneField(String fieldName, BiConsumer<String, CandidateData> setter) {
        super(fieldName, setter);
    }

    @Override
    public ValidationResult validate(String cellValue) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(cellValue);

        return matcher.matches() ? new ValidationResult(true, "") : new ValidationResult(false, super.getFieldName() + " is invalid");
    }
}
