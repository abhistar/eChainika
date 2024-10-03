package com.echainika.app.model.dto.response;

import com.echainika.app.model.dto.CandidateData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AllCandidatesResponse {
    private List<CandidateData> candidates;
    private Long totalCandidates;
    private Integer startIndex;
    private Integer endIndex;
}
