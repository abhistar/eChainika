package com.echainika.app.model;


import com.echainika.app.model.dto.request.CandidateRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CandidateValidationResult {
    private List<CandidateRequest> candidates;
    private List<Error> errors;
}
