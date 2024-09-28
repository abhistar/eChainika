package com.echainika.app.utils.ValidatorImpl;

import com.echainika.app.model.Error;
import com.echainika.app.utils.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TimeOfBirthValidator implements Validator {
    @Override
    public Boolean validate(Integer rowNumber, String cellValue, List<Error> errorList) {
        try {
            LocalDate.parse(cellValue, DateTimeFormatter.ISO_LOCAL_TIME);
            return true;
        } catch (DateTimeParseException de) {
            errorList.add(Error.builder().error("Time of birth in wrong format").rowNumber(rowNumber).build());
        } catch (NullPointerException ne) {
            errorList.add(Error.builder().error("Time of birth absent").rowNumber(rowNumber).build());
        }
        return false;
    }
}
