package com.echainika.app.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private Integer rowNumber;
    private String error;
}
