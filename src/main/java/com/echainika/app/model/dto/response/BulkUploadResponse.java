package com.echainika.app.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BulkUploadResponse {
    private Integer rowNumber;
    private String error;
}
