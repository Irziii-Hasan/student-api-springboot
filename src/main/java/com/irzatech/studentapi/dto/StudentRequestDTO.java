package com.irzatech.studentapi.dto;
import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 1, message = "Age must be a positive number")
    private int age;

    @NotBlank(message = "Department is required")
    private String department;

    @Pattern(regexp = "^\\d{4}-\\d{6}$", message = "Roll number must match format: 2021-123456")
    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @NotBlank(message = "Gender is required")
    private String gender;
}
