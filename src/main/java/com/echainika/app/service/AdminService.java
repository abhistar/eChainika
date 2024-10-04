package com.echainika.app.service;

import com.echainika.app.model.CandidatesResult;
import com.echainika.app.model.dto.CandidateData;
import com.echainika.app.model.dto.response.AllCandidatesResponse;
import com.echainika.app.model.dto.response.BulkUploadResponse;
import com.echainika.app.model.entity.CandidateEntity;
import com.echainika.app.repository.CandidateRepository;
import com.echainika.app.utils.ExcelUtils;
import com.echainika.app.utils.CandidateMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

            candidateRepository.saveAll(candidatesResult.getCandidates().stream().map(this::createOrUpdate).collect(Collectors.toList()));
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


    public AllCandidatesResponse getAllCandidates(Integer numberOfEntries, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, numberOfEntries);
        Page<CandidateEntity> candidates = candidateRepository.findAll(pageable);

        return AllCandidatesResponse.builder()
                .candidates(candidates.stream().map(CandidateMapperUtil::candidateMapper).toList())
                .totalPages(candidates.getTotalPages())
                .build();
    }

    public String bulkDownloadData() {
        return "Downloading data...";
    }

    private CandidateEntity createOrUpdate(CandidateData candidateRequest) {
        List<CandidateEntity> candidateEntityList = candidateRepository.findByRegistrationNumber(candidateRequest.getRegistrationNumber());

        if (candidateEntityList == null || candidateEntityList.isEmpty()) {
            return CandidateMapperUtil.candidateMapper(candidateRequest);
        }
        return CandidateMapperUtil.updateCandidateMapper(candidateRequest, candidateEntityList.get(0));
    }
}
