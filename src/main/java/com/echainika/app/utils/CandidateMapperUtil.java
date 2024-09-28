package com.echainika.app.utils;

import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.entity.CandidateEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CandidateMapperUtil {
    public static CandidateEntity candidateMapper(CandidateRequest candidate) {
        return CandidateEntity.builder()
                .registrationNumber(candidate.getRegistrationNumber())
                .name(candidate.getName())
                .maritalStatus(candidate.getMaritalStatus()) // TODO: Add other fields
                .build();
    }

    public static void updateCandidateMapper(CandidateRequest candidateRequest, CandidateEntity candidateEntity) {
        if (candidateRequest.getName() != null) {
            candidateEntity.setName(candidateRequest.getName());
        }
        // TODO: Add other fields
    }
}
