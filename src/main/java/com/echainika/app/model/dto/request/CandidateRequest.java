package com.echainika.app.model.dto.request;


import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.model.enums.OccupationType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class CandidateRequest {
    private String registrationNumber;
    private String name;
    private MaritalStatus maritalStatus;
    private LocalDate dateOfBirth;
    private LocalTime timeOfBirth;
    private String placeOfBirth;
    private String education;
    private OccupationType occupationType;
    private String occupationDetail;
    private String income;
    private String height;
    private Integer weight;
    private String complexion;
    private Boolean manglik;
    private String gotra;
    private String nakshatra;
    private String mamaGotra;
    private String fatherName;
    private String motherName;
    private OccupationType parentOccupationType;
    private String parentOccupationDetail;
    private String parentIncome;
    private String siblings;
    private String address;
    private String contactNumber;
    private String poc;
    private String pocContactNumber;
    private String special;
    private String otherDetails;
    private String photoUrl;
}
