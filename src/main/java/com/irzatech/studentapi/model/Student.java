package com.irzatech.studentapi.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @Min(value = 1, message = "Age must be a positive number")
    private int age;

    @NotBlank(message = "Department is required")
    private String department;

    @Pattern(regexp = "^\\d{4}-\\d{6}$", message = "Roll number must match format: 2021-123456")
    @NotBlank (message= "roll no. is required")
    @Column(nullable = false)
    private String rollNumber;

    @NotBlank(message = "Gender is required")
    private String gender;
}