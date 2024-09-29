package com.echainika.app.utils.StrategyManager;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.utils.FieldStrategy;

import java.util.function.BiConsumer;

public class GenericField extends FieldStrategy {
    public GenericField(String fieldName, BiConsumer<String, CandidateRequest> setter) {
        super(fieldName, setter);
    }
}
