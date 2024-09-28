package com.echainika.app.model.entity;

import com.echainika.app.model.enums.MaritalStatus;
import com.echainika.app.model.enums.OccupationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "tob")
    private LocalTime timeOfBirth;

    @Column(name = "place")
    private String placeOfBirth;

    @Column(name = "education")
    private String education;

    @Column(name = "occupation_type", length = 15)
    private OccupationType occupationType;

    @Column(name = "occupation_detail")
    private String occupationDetail;

    @Column(name = "income", length = 127)
    private String income;

    @Column(name = "height", length = 5)
    private String height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "complexion", length = 31)
    private String complexion;

    @Column(name = "manglik")
    private Boolean manglik;

    @Column(name = "gotra", length = 127)
    private String gotra;

    @Column(name = "nakshatra", length = 127)
    private String nakshatra;

    @Column(name = "mama_gotra", length = 127)
    private String mamaGotra;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "parent_occupation_type", length = 15)
    private OccupationType parentOccupationType;

    @Column(name = "parent_occupation_detail")
    private String parentOccupationDetail;

    @Column(name = "parent_income", length = 127)
    private String parentIncome;

    @Column(name = "siblings")
    private String siblings;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number", length = 10)
    private String contactNumber;

    @Column(name = "poc")
    private String poc;

    @Column(name = "poc_contact_number", length = 10)
    private String pocContactNumber;

    @Column(name = "special", length = 127)
    private String special;

    @Column(name = "other_details", length = 127)
    private String otherDetails;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
