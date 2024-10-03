package com.echainika.app.model;


import com.echainika.app.model.dto.CandidateData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CandidatesResult {
    private List<CandidateData> candidates;
    private List<Error> errors;
}
