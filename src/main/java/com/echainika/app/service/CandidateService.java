package com.echainika.app.service;

import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    // Create
    public String createCandidateEntity(CandidateEntity candidate) {
        candidateRepository.save(candidate);
        return "Candidate profile created successfully";
    }

    // Read
    public CandidateEntity getCandidateEntityById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // Update
    public String updateCandidateEntity(CandidateEntity candidate) {
        candidateRepository.save(candidate);
        return "Candidate profile updated successfully";
    }

    // Delete
    public String deleteCandidateEntity(Long id) {
        candidateRepository.deleteById(id);
        return "Candidate profile deleted successfully";
    }
}
