package com.echainika.app.service;

import com.echainika.app.model.CandidateAndErrors;
import com.echainika.app.model.dto.request.CandidateRequest;
import com.echainika.app.model.dto.response.BulkUploadResponse;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import com.echainika.app.utils.ExcelUtils;
import com.echainika.app.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CandidateRepository candidateRepository;

    public BulkUploadResponse bulkUploadData(MultipartFile file) {
        try {
            CandidateAndErrors candidateAndErrors = ExcelUtils.parseExcelFile(file.getInputStream());

            candidateRepository.saveAll(candidateAndErrors.getCandidates().stream().map(MapperUtils::candidateMapper).collect(Collectors.toList()));
            if (!candidateAndErrors.getErrors().isEmpty()) {
                return BulkUploadResponse.builder().message("Errors detected in more than 1 row")
                        .errors(candidateAndErrors.getErrors()).build();
            }

            return BulkUploadResponse.builder().message("All row processed successfully").build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data" + e.getMessage());
        }
    }

    public String editCandidate(CandidateRequest candidateRequest) {
        CandidateEntity candidate = candidateRepository.findByRegistrationNumber(candidateRequest.getRegistrationNumber());
        MapperUtils.updateCandidateMapper(candidateRequest, candidate);
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
