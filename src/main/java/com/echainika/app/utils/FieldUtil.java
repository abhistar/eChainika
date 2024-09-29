package com.echainika.app.utils;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.utils.StrategyManager.*;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public final class FieldUtil {
    public static final String REGISTRATION_NUMBER = "registrationNumber";
    public static final String NAME = "name";
    public static final String MARITAL_STATUS = "maritalStatus";
    public static final String DATE_OF_BIRTH = "dateOfBirth";
    public static final String TIME_OF_BIRTH = "timeOfBirth";
    public static final String placeOfBirth = "placeOfBirth";
    public static final String education = "education";
    public static final String occupationType = "occupationType";
    public static final String occupationDetail = "occupationDetail";
    public static final String income = "income";
    public static final String height = "height";
    public static final String weight = "weight";
    public static final String complexion = "complexion";
    public static final String manglik = "manglik";
    public static final String gotra = "gotra";
    public static final String nakshatra = "nakshatra";
    public static final String mamaGotra = "mamaGotra";
    public static final String fatherName = "fatherName";
    public static final String motherName = "motherName";
    public static final String parentOccupationType = "parentOccupationType";
    public static final String parentOccupationDetail = "parentOccupationDetail";
    public static final String parentIncome = "parentIncome";
    public static final String siblings = "siblings";
    public static final String address = "address";
    public static final String contactNumber = "contactNumber";
    public static final String poc = "poc";
    public static final String pocContactNumber = "pocContactNumber";
    public static final String special = "special";
    public static final String otherDetails = "otherDetails";
    public static final String photoUrl = "photoUrl";

    public static Map<String, FieldStrategy> COLUMN_STRATEGY_MAP = Map.of(
            REGISTRATION_NUMBER, new RegistrationNumberField(REGISTRATION_NUMBER),
            NAME, new NameField(NAME),
            MARITAL_STATUS, new MaritalStatusField(MARITAL_STATUS),
            DATE_OF_BIRTH, new DateOfBirthField(DATE_OF_BIRTH),
            TIME_OF_BIRTH, new TimeOfBirthField(TIME_OF_BIRTH)
            );
}
