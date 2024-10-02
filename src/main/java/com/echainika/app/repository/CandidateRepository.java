package com.echainika.app.repository;

import com.echainika.app.model.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository  extends JpaRepository<CandidateEntity,Long> {
    List<CandidateEntity> findByRegistrationNumber(String registrationNumber);
}
