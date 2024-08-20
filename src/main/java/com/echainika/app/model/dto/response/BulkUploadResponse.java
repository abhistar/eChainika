package com.echainika.app.model.dto.response;

import com.echainika.app.model.Error;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BulkUploadResponse {
    private String message;
    private List<Error> errors;
}
