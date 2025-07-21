package com.irzatech.studentapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irzatech.studentapi.dto.StudentRequestDTO;
import com.irzatech.studentapi.dto.StudentResponseDTO;
//import com.irzatech.studentapi.dto.StudentRequestDTO;
//import com.irzatech.studentapi.dto.StudentResponseDTO;
import com.irzatech.studentapi.model.Student;
import com.irzatech.studentapi.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;
	
//	Constructor Injection
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
//	StudentController
	@GetMapping
	public List<StudentResponseDTO> getAllStudents(){
		return studentService.getAllStudents();
	}
	
//  POST create a new student
	@PostMapping
	public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
		StudentResponseDTO studentResponseDTO =  studentService.saveStudent(studentRequestDTO);
		return ResponseEntity.ok(studentResponseDTO);
	}
	
//	PUT update Student values
	@PutMapping("/{id}")
	public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO dto){
		StudentResponseDTO student = studentService.updateStudent(id, dto);
		return ResponseEntity.ok(student);
	}
	
//	Delete Student record
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id, @RequestBody Student deleteStudent){
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully.");
	
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<StudentResponseDTO> patchStudent(
	        @PathVariable Long id,
	        @RequestBody StudentRequestDTO dto) {
	    StudentResponseDTO student = studentService.patchStudent(id, dto);
	    return ResponseEntity.ok(student);
	}

	
}
