package com.echainika.app.utils.ValidatorImpl;

import com.echainika.app.model.Error;
import com.echainika.app.utils.Validator;

import java.util.List;

public class RegistrationNumberValidator implements  Validator {
    @Override
    public Boolean validate(Integer rowNumber, String cellValue, List<Error> errorList) {
        if(cellValue == null) {
            errorList.add(Error.builder().error("Registration number absent").rowNumber(rowNumber).build());
            return false;
        }
        return true;
    }
}
