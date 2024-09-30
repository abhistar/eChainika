package com.echainika.app.utils;

import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.model.enums.OccupationType;
import com.echainika.app.utils.StrategyManager.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@UtilityClass
public final class FieldUtil {
    public static final String REGISTRATION_NUMBER = "registrationNumber";
    public static final String NAME = "name";
    public static final String MARITAL_STATUS = "maritalStatus";
    public static final String DATE_OF_BIRTH = "dateOfBirth";
    public static final String TIME_OF_BIRTH = "timeOfBirth";
    public static final String PLACE_OF_BIRTH = "placeOfBirth";
    public static final String EDUCATION = "education";
    public static final String OCCUPATION_TYPE = "occupationType";
    public static final String OCCUPATION_DETAIL = "occupationDetail";
    public static final String INCOME = "income";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String COMPLEXION = "complexion";
    public static final String MANGLIK = "manglik";
    public static final String GOTRA = "gotra";
    public static final String NAKSHATRA = "nakshatra";
    public static final String MAMA_GOTRA = "mamaGotra";
    public static final String FATHER_NAME = "fatherName";
    public static final String MOTHER_NAME = "motherName";
    public static final String PARENT_OCCUPATION_TYPE = "parentOccupationType";
    public static final String PARENT_OCCUPATION_DETAIL = "parentOccupationDetail";
    public static final String PARENT_INCOME = "parentIncome";
    public static final String SIBLINGS = "siblings";
    public static final String ADDRESS = "address";
    public static final String CONTACT_NUMBER = "contactNumber";
    public static final String POC = "poc";
    public static final String POC_CONTACT_NUMBER = "pocContactNumber";
    public static final String SPECIAL = "special";
    public static final String OTHER_DETAILS = "otherDetails";
    public static final String PHOTO_URL = "photoUrl";

    public static Map<String, FieldStrategy> COLUMN_STRATEGY_MAP = Map.ofEntries(
            Map.entry(REGISTRATION_NUMBER, new GenericField(REGISTRATION_NUMBER, (cv, cr) -> cr.setRegistrationNumber(cv))),
            Map.entry(NAME, new GenericField(NAME, (cv, cr) -> cr.setName(cv))),
            Map.entry(MARITAL_STATUS, new MaritalEnumField(MARITAL_STATUS, (cv, cr) -> cr.setMaritalStatus(MaritalStatus.valueOf(cv.toUpperCase())))),
            Map.entry(DATE_OF_BIRTH, new DateField(DATE_OF_BIRTH, (cv, cr) -> cr.setDateOfBirth(LocalDate.parse(cv, DateTimeFormatter.ISO_LOCAL_DATE)))),
            Map.entry(TIME_OF_BIRTH, new TimeField(TIME_OF_BIRTH, (cv, cr) -> cr.setTimeOfBirth(LocalTime.parse(cv, DateTimeFormatter.ISO_LOCAL_TIME)))),
            Map.entry(PLACE_OF_BIRTH, new GenericField(PLACE_OF_BIRTH, (cv, cr) -> cr.setPlaceOfBirth(cv))),
            Map.entry(EDUCATION, new GenericField(EDUCATION, (cv, cr) -> cr.setEducation(cv))),
            Map.entry(OCCUPATION_TYPE, new OccupationEnumField(OCCUPATION_TYPE, (cv, cr) -> cr.setOccupationType(OccupationType.valueOf(cv.toUpperCase())))),
            Map.entry(OCCUPATION_DETAIL, new GenericField(OCCUPATION_DETAIL, (cv, cr) -> cr.setOccupationDetail(cv))),
            Map.entry(INCOME, new GenericField(INCOME, (cv, cr) -> cr.setIncome(cv))),
            Map.entry(HEIGHT, new GenericField(HEIGHT, (cv, cr) -> cr.setHeight(cv))),
            Map.entry(WEIGHT, new GenericField(WEIGHT, (cv, cr) -> cr.setWeight(Integer.valueOf(cv)))),
            Map.entry(COMPLEXION, new GenericField(COMPLEXION, (cv, cr) -> cr.setComplexion(cv))),
            Map.entry(MANGLIK, new GenericField(MANGLIK, (cv, cr) -> cr.setManglik(Boolean.valueOf(cv)))),
            Map.entry(GOTRA, new GenericField(GOTRA, (cv, cr) -> cr.setGotra(cv))),
            Map.entry(NAKSHATRA, new GenericField(NAKSHATRA, (cv, cr) -> cr.setNakshatra(cv))),
            Map.entry(MAMA_GOTRA, new GenericField(MAMA_GOTRA, (cv, cr) -> cr.setMamaGotra(cv))),
            Map.entry(FATHER_NAME, new GenericField(FATHER_NAME, (cv, cr) -> cr.setFatherName(cv))),
            Map.entry(MOTHER_NAME, new GenericField(MOTHER_NAME, (cv, cr) -> cr.setMotherName(cv))),
            Map.entry(PARENT_OCCUPATION_TYPE, new OccupationEnumField(PARENT_OCCUPATION_TYPE, (cv, cr) -> cr.setParentOccupationType(OccupationType.valueOf(cv.toUpperCase())))),
            Map.entry(PARENT_OCCUPATION_DETAIL, new GenericField(PARENT_OCCUPATION_DETAIL, (cv, cr) -> cr.setParentOccupationDetail(cv))),
            Map.entry(PARENT_INCOME, new GenericField(PARENT_INCOME, (cv, cr) -> cr.setParentIncome(cv))),
            Map.entry(SIBLINGS, new GenericField(SIBLINGS, (cv, cr) -> cr.setSiblings(cv))),
            Map.entry(ADDRESS, new GenericField(ADDRESS, (cv, cr) -> cr.setAddress(cv))),
            Map.entry(CONTACT_NUMBER, new GenericField(CONTACT_NUMBER, (cv, cr) -> cr.setContactNumber(cv))),
            Map.entry(POC, new GenericField(POC, (cv, cr) -> cr.setPoc(cv))),
            Map.entry(POC_CONTACT_NUMBER, new GenericField(POC_CONTACT_NUMBER, (cv, cr) -> cr.setPocContactNumber(cv))),
            Map.entry(SPECIAL, new GenericField(SPECIAL, (cv, cr) -> cr.setSpecial(cv))),
            Map.entry(OTHER_DETAILS, new GenericField(OTHER_DETAILS, (cv, cr) -> cr.setOtherDetails(cv))),
            Map.entry(PHOTO_URL, new GenericField(PHOTO_URL, (cv, cr) -> cr.setPhotoUrl(cv))),
            Map.entry("", new GenericField("", (cv, cr) -> {}))
    );
}
