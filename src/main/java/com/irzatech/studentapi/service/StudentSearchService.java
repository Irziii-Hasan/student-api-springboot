package com.irzatech.studentapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irzatech.studentapi.dto.StudentMapper;
import com.irzatech.studentapi.dto.StudentResponseDTO;
import com.irzatech.studentapi.model.Student;
import com.irzatech.studentapi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentSearchService {

	@Autowired
	public final StudentRepository studentRepository;

	public StudentResponseDTO searchStudentById(Long id){
		Student stdListbyId = studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Can't fint student with id: "+id));
		return StudentMapper.entityToDto(stdListbyId);
	}
	
	public List<StudentResponseDTO> searchStudentByName(String name){
		List<Student> student = studentRepository.findByName(name);
		return student.stream()
				.map(StudentMapper :: entityToDto)
				.toList();
	}
	
	public List<StudentResponseDTO> searchStudentByDepartment(String dept){
		List<Student> students = studentRepository.findByDepartment(dept);
		return students.stream()
				.map(StudentMapper :: entityToDto)
				.collect(Collectors.toList());
	}
	
	public List<StudentResponseDTO> searchStudentByNameAndDept(String name, String dept){
		List<Student> students = studentRepository.findByNameAndDepartment(name, dept);
		return students.stream()
				.map(StudentMapper :: entityToDto)
				.collect(Collectors.toList());
		
	}
}
