package com.echainika.app.utils;

import com.echainika.app.model.Error;
import com.echainika.app.model.dto.request.CandidateRequest;

import java.util.List;

public interface Validator {
    Boolean validate(Integer rowNumber, String cellValue, List<Error> errorList);
}
