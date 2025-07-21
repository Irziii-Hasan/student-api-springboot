package com.irzatech.studentapi.dto;
import lombok.Data;

@Data
public class StudentResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private int age;
    private String department;
    private String rollNumber;
    private String gender;
}
