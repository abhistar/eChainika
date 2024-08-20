package com.echainika.app.repository;

import com.echainika.app.model.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository  extends JpaRepository<CandidateEntity,Long> {
    CandidateEntity findByRegistrationNumber(String registrationNumber);
}
