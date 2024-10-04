package com.echainika.app.utils;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.model.enums.Gender;
import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.model.enums.OccupationType;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalTime;

@UtilityClass
public final class CandidateMapperUtil {
    public static CandidateEntity candidateMapper(CandidateData candidate) {
        return CandidateEntity.builder()
                .registrationNumber(candidate.getRegistrationNumber())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .gender(candidate.getGender())
                .maritalStatus(candidate.getMaritalStatus())
                .dateOfBirth(candidate.getDateOfBirth())
                .timeOfBirth(candidate.getTimeOfBirth())
                .placeOfBirth(candidate.getPlaceOfBirth())
                .education(candidate.getEducation())
                .occupationType(candidate.getOccupationType())
                .occupationDetail(candidate.getOccupationDetail())
                .income(candidate.getIncome())
                .height(candidate.getHeight())
                .weight(candidate.getWeight())
                .complexion(candidate.getComplexion())
                .manglik(candidate.getManglik())
                .gotra(candidate.getGotra())
                .nakshatra(candidate.getNakshatra())
                .mamaGotra(candidate.getMamaGotra())
                .fatherName(candidate.getFatherName())
                .motherName(candidate.getMotherName())
                .parentOccupationType(candidate.getParentOccupationType())
                .parentOccupationDetail(candidate.getParentOccupationDetail())
                .parentIncome(candidate.getParentIncome())
                .siblings(candidate.getSiblings())
                .address(candidate.getAddress())
                .contactNumber(candidate.getContactNumber())
                .poc(candidate.getPoc())
                .pocContactNumber(candidate.getPocContactNumber())
                .special(candidate.getSpecial())
                .otherDetails(candidate.getOtherDetails())
                .photoUrl(candidate.getPhotoUrl())
                .build();
    }

    public static CandidateEntity updateCandidateMapper(CandidateData candidateRequest, CandidateEntity candidateEntity) {
        CandidateEntity.CandidateEntityBuilder candidateEntityBuilder = candidateEntity.toBuilder();

        candidateEntityBuilder
                .firstName((String) getOrDefault(candidateRequest.getFirstName(), candidateEntity.getFirstName()))
                .lastName((String) getOrDefault(candidateRequest.getLastName(), candidateEntity.getLastName()))
                .gender((Gender) getOrDefault(candidateRequest.getGender(), candidateEntity.getGender()))
                .maritalStatus((MaritalStatus) getOrDefault(candidateRequest.getMaritalStatus(), candidateEntity.getMaritalStatus()))
                .dateOfBirth((LocalDate) getOrDefault(candidateRequest.getDateOfBirth(), candidateEntity.getDateOfBirth()))
                .timeOfBirth((LocalTime) getOrDefault(candidateRequest.getTimeOfBirth(), candidateEntity.getTimeOfBirth()))
                .placeOfBirth((String) getOrDefault(candidateRequest.getPlaceOfBirth(), candidateEntity.getPlaceOfBirth()))
                .education((String) getOrDefault(candidateRequest.getEducation(), candidateEntity.getEducation()))
                .occupationType((OccupationType) getOrDefault(candidateRequest.getOccupationType(), candidateEntity.getOccupationType()))
                .occupationDetail((String) getOrDefault(candidateRequest.getOccupationDetail(), candidateEntity.getOccupationDetail()))
                .income((String) getOrDefault(candidateRequest.getIncome(), candidateEntity.getIncome()))
                .height((String) getOrDefault(candidateRequest.getHeight(), candidateEntity.getHeight()))
                .weight((Integer) getOrDefault(candidateRequest.getWeight(), candidateEntity.getWeight()))
                .complexion((String) getOrDefault(candidateRequest.getComplexion(), candidateEntity.getComplexion()))
                .manglik((Boolean) getOrDefault(candidateRequest.getManglik(), candidateEntity.getManglik()))
                .gotra((String) getOrDefault(candidateRequest.getGotra(), candidateEntity.getGotra()))
                .nakshatra((String) getOrDefault(candidateRequest.getNakshatra(), candidateEntity.getNakshatra()))
                .mamaGotra((String) getOrDefault(candidateRequest.getMamaGotra(), candidateEntity.getMamaGotra()))
                .fatherName((String) getOrDefault(candidateRequest.getFatherName(), candidateEntity.getFatherName()))
                .motherName((String) getOrDefault(candidateRequest.getMotherName(), candidateEntity.getMotherName()))
                .parentOccupationType((OccupationType) getOrDefault(candidateRequest.getParentOccupationType(), candidateEntity.getParentOccupationType()))
                .parentOccupationDetail((String) getOrDefault(candidateRequest.getParentOccupationDetail(), candidateEntity.getParentOccupationDetail()))
                .parentIncome((String) getOrDefault(candidateRequest.getParentIncome(), candidateEntity.getParentIncome()))
                .siblings((String) getOrDefault(candidateRequest.getSiblings(), candidateEntity.getSiblings()))
                .address((String) getOrDefault(candidateRequest.getAddress(), candidateEntity.getAddress()))
                .contactNumber((String) getOrDefault(candidateRequest.getContactNumber(), candidateEntity.getContactNumber()))
                .poc((String) getOrDefault(candidateRequest.getPoc(), candidateEntity.getPoc()))
                .pocContactNumber((String) getOrDefault(candidateRequest.getPocContactNumber(), candidateEntity.getPocContactNumber()))
                .special((String) getOrDefault(candidateRequest.getSpecial(), candidateEntity.getSpecial()))
                .otherDetails((String) getOrDefault(candidateRequest.getOtherDetails(), candidateEntity.getOtherDetails()))
                .photoUrl((String) getOrDefault(candidateRequest.getPhotoUrl(), candidateEntity.getPhotoUrl()));

        return candidateEntityBuilder.build();
    }

    private static Object getOrDefault(Object fieldValue, Object defaultValue) {
        return fieldValue != null ? fieldValue : defaultValue;
    }

    public static CandidateData candidateMapper(CandidateEntity candidate) {
        return CandidateData.builder()
                .registrationNumber(candidate.getRegistrationNumber())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .gender(candidate.getGender())
                .maritalStatus(candidate.getMaritalStatus())
                .dateOfBirth(candidate.getDateOfBirth())
                .timeOfBirth(candidate.getTimeOfBirth())
                .placeOfBirth(candidate.getPlaceOfBirth())
                .education(candidate.getEducation())
                .occupationType(candidate.getOccupationType())
                .occupationDetail(candidate.getOccupationDetail())
                .income(candidate.getIncome())
                .height(candidate.getHeight())
                .weight(candidate.getWeight())
                .complexion(candidate.getComplexion())
                .manglik(candidate.getManglik())
                .gotra(candidate.getGotra())
                .nakshatra(candidate.getNakshatra())
                .mamaGotra(candidate.getMamaGotra())
                .fatherName(candidate.getFatherName())
                .motherName(candidate.getMotherName())
                .parentOccupationType(candidate.getParentOccupationType())
                .parentOccupationDetail(candidate.getParentOccupationDetail())
                .parentIncome(candidate.getParentIncome())
                .siblings(candidate.getSiblings())
                .address(candidate.getAddress())
                .contactNumber(candidate.getContactNumber())
                .poc(candidate.getPoc())
                .pocContactNumber(candidate.getPocContactNumber())
                .special(candidate.getSpecial())
                .otherDetails(candidate.getOtherDetails())
                .photoUrl(candidate.getPhotoUrl())
                .build();
    }
}
