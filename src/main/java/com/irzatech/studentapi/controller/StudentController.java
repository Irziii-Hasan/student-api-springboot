package com.irzatech.studentapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irzatech.studentapi.model.Student;
import com.irzatech.studentapi.service.StudentService;

import org.apache.catalina.connector.Response;
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
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
//  POST create a new student
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
//	PUT update Student values
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
		Student student = studentService.updateStudent(id, updatedStudent);
		return ResponseEntity.ok(student);
	}
	
	
}
