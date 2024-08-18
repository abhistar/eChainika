package com.echainika.app.service;

import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    // Create
    public CandidateEntity createCandidateEntity(CandidateEntity candidate) {
        return candidateRepository.save(candidate);
    }

    // Read
    public CandidateEntity getCandidateEntityById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // Update
    public CandidateEntity updateCandidateEntity(CandidateEntity candidate) {
        return candidateRepository.save(candidate);
    }

    // Delete
    public void deleteCandidateEntity(Long id) {
        candidateRepository.deleteById(id);
    }
}
