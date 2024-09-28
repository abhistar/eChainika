package com.echainika.app.service;

import com.echainika.app.model.CandidateValidationResult;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.dto.response.BulkUploadResponse;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import com.echainika.app.utils.ExcelUtils;
import com.echainika.app.utils.CandidateMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CandidateRepository candidateRepository;

    public BulkUploadResponse bulkUploadData(MultipartFile file) {
        try {
            CandidateValidationResult candidateValidationResult = ExcelUtils.parseExcelFile(file.getInputStream());

            candidateRepository.saveAll(candidateValidationResult.getCandidates().stream().map(CandidateMapperUtil::candidateMapper).collect(Collectors.toList()));
            if (!candidateValidationResult.getErrors().isEmpty()) {
                return BulkUploadResponse.builder().message("Errors detected in more than 1 row")
                        .errors(candidateValidationResult.getErrors()).build();
            }

            return BulkUploadResponse.builder().message("All row processed successfully").build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data" + e.getMessage());
        }
    }

    public String editCandidate(CandidateRequest candidateRequest) {
        CandidateEntity candidate = candidateRepository.findByRegistrationNumber(candidateRequest.getRegistrationNumber());
        CandidateMapperUtil.updateCandidateMapper(candidateRequest, candidate);
        candidateRepository.save(candidate);
        return "Candidate data edited successfully";
    }

    public String bulkDelete() {
        candidateRepository.deleteAll();
        return "All entries deleted successfully";
    }


    public String getAllCandidates(Integer numberOfEntries, Integer pageNumber) {
        return String.format("Giving %d entries in page number %d", numberOfEntries, pageNumber);
    }

    public String bulkDownloadData() {
        return "Downloading data...";
    }
}
