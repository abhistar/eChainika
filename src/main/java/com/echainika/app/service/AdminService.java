package com.echainika.app.service;

import com.echainika.app.model.dto.response.BulkUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    public List<BulkUploadResponse> bulkUploadData(Object data) {
        return List.of(BulkUploadResponse.builder().rowNumber(1).error("Test error").build());
    }

    public String editCandidate(Object data) {
        return "Candidate data edited successfully";
    }

    public String bulkDelete() {
        return "All entries deleted successfully";
    }


    public String getAllCandidates(Integer numberOfEntries, Integer pageNumber) {
        return String.format("Giving %d entries in page number %d", numberOfEntries, pageNumber);
    }

    public String bulkDownloadData() {
        return "Downloading data...";
    }
}
