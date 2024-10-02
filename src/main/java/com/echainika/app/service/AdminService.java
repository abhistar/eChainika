package com.echainika.app.service;

import com.echainika.app.model.CandidatesResult;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final CandidateRepository candidateRepository;

    public BulkUploadResponse bulkUploadData(MultipartFile file) {
        try {
            CandidatesResult candidatesResult = ExcelUtils.parseExcelFile(file.getInputStream());

            candidateRepository.saveAll(candidatesResult.getCandidates().stream().map(cd -> updateOrCreate(cd, candidateRepository)).collect(Collectors.toList()));
            if (!candidatesResult.getErrors().isEmpty()) {
                return BulkUploadResponse.builder().message("Errors detected in more than 1 row")
                        .errors(candidatesResult.getErrors()).build();
            }

            return BulkUploadResponse.builder().message("All row processed successfully").build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data" + e.getMessage());
        }
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

    private CandidateEntity updateOrCreate(CandidateRequest candidateRequest, CandidateRepository candidateRepository) {
        List<CandidateEntity> candidateEntityList = candidateRepository.findByRegistrationNumber(candidateRequest.getRegistrationNumber());

        if (!(candidateEntityList == null || candidateEntityList.isEmpty())) {
            return CandidateMapperUtil.updateCandidateMapper(candidateRequest, candidateEntityList.get(0));
        }
        return CandidateMapperUtil.candidateMapper(candidateRequest);
    }
}
