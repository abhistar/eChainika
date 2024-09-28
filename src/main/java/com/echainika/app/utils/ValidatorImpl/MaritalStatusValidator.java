package com.echainika.app.utils.ValidatorImpl;

import com.echainika.app.model.Error;
import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.utils.Validator;

import java.util.List;

public class MaritalStatusValidator implements Validator {
    @Override
    public Boolean validate(Integer rowNumber, String cellValue, List<Error> errorList) {
        try {
            MaritalStatus.valueOf(cellValue.toUpperCase());
            return true;
        } catch (NullPointerException ne) {
            errorList.add(Error.builder().error("Marital Status absent").rowNumber(rowNumber).build());
        } catch (IllegalArgumentException ie) {
            errorList.add(Error.builder().error("Marital status does not match with any values").rowNumber(rowNumber).build());
        }
        return false;
    }
}
