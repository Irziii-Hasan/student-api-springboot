package com.irzatech.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irzatech.studentapi.dto.StudentResponseDTO;
import com.irzatech.studentapi.service.StudentSearchService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/students/search")
public class StudentSearchController {
	
	@Autowired
	private final StudentSearchService searchService;
	
	
	@GetMapping ("by-id")
	public StudentResponseDTO searchStudentByName(@PathVariable Long id){
		return searchService.searchStudentById(id);
	}
	
	@GetMapping ("by-name")
	public List<StudentResponseDTO> searchStudentByName(@RequestParam String name){
		return searchService.searchStudentByName(name);
	}
	
	@GetMapping ("by-department")
	public List<StudentResponseDTO> searchStudentByDept(@RequestParam String department){
		return searchService.searchStudentByDepartment(department);
	}
	
	@GetMapping ("by-name-department")
	public List<StudentResponseDTO> searchStudentByNameAndDept(@RequestParam String name, @RequestParam String department){
		return searchService.searchStudentByNameAndDept(name, department);
	}
}
