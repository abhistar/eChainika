package com.echainika.app.utils;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.model.enums.OccupationType;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalTime;

@UtilityClass
public final class CandidateMapperUtil {
    public static CandidateEntity candidateMapper(CandidateRequest candidate) {
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

    public static CandidateEntity updateCandidateMapper(CandidateRequest candidateRequest, CandidateEntity candidateEntity) {
        CandidateEntity.CandidateEntityBuilder candidateEntityBuilder = candidateEntity.toBuilder();

        /* Only fields highly relevant to candidate are allowed to be edited */
        candidateEntityBuilder.firstName((String) getOrDefault(candidateRequest.getFirstName(), candidateEntity.getFirstName()));
        candidateEntityBuilder.lastName((String) getOrDefault(candidateRequest.getLastName(), candidateEntity.getLastName()));
        candidateEntityBuilder.dateOfBirth((LocalDate) getOrDefault(candidateRequest.getDateOfBirth(), candidateEntity.getDateOfBirth()));
        candidateEntityBuilder.timeOfBirth((LocalTime) getOrDefault(candidateRequest.getTimeOfBirth(), candidateEntity.getTimeOfBirth()));
        candidateEntityBuilder.placeOfBirth((String) getOrDefault(candidateRequest.getPlaceOfBirth(), candidateEntity.getPlaceOfBirth()));
        candidateEntityBuilder.occupationType((OccupationType) getOrDefault(candidateRequest.getOccupationType(), candidateEntity.getOccupationType()));
        candidateEntityBuilder.occupationDetail((String) getOrDefault(candidateRequest.getOccupationDetail(), candidateEntity.getOccupationDetail()));
        candidateEntityBuilder.income((String) getOrDefault(candidateRequest.getIncome(), candidateEntity.getIncome()));
        candidateEntityBuilder.height((String) getOrDefault(candidateRequest.getHeight(), candidateEntity.getHeight()));
        candidateEntityBuilder.weight((Integer) getOrDefault(candidateRequest.getWeight(), candidateEntity.getWeight()));
        candidateEntityBuilder.complexion((String) getOrDefault(candidateRequest.getComplexion(), candidateEntity.getComplexion()));
        candidateEntityBuilder.address((String) getOrDefault(candidateRequest.getAddress(), candidateEntity.getAddress()));
        candidateEntityBuilder.contactNumber((String) getOrDefault(candidateRequest.getContactNumber(), candidateEntity.getContactNumber()));
        candidateEntityBuilder.poc((String) getOrDefault(candidateRequest.getPoc(), candidateEntity.getPoc()));
        candidateEntityBuilder.pocContactNumber((String) getOrDefault(candidateRequest.getPocContactNumber(), candidateEntity.getPocContactNumber()));

        return candidateEntityBuilder.build();
    }

    private static Object getOrDefault(Object fieldValue, Object defaultValue) {
        return fieldValue != null ? fieldValue : defaultValue;
    }
}
