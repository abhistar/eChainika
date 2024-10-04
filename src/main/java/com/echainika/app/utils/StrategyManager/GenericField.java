package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.utils.FieldStrategy;

import java.util.function.BiConsumer;

public class GenericField extends FieldStrategy {
    public GenericField(String fieldName, BiConsumer<String, CandidateData> setter) {
        super(fieldName, setter);
    }
}
