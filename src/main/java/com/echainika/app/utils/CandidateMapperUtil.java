package com.echainika.app.utils;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.model.entity.CandidateEntity;
import lombok.experimental.UtilityClass;

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

    public static void updateCandidateMapper(CandidateData candidateData, CandidateEntity candidateEntity) {
        if (candidateData.getFirstName() != null) {
            candidateEntity.setFirstName(candidateData.getFirstName());
        }
        // TODO: Add other fields
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
