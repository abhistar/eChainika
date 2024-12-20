package com.echainika.app.service;

import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import com.echainika.app.utils.CandidateMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    // Create
    public String createCandidate(CandidateData candidate) {
        candidateRepository.save(CandidateMapperUtil.candidateDataToEntity(candidate));
        return "Candidate profile created successfully";
    }

    // Read
    public CandidateEntity getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // Update
    public String updateCandidate(CandidateData candidate) {
        candidateRepository.save(CandidateMapperUtil.candidateDataToEntity(candidate));
        return "Candidate profile updated successfully";
    }

    // Delete
    public String deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
        return "Candidate profile deleted successfully";
    }
}
