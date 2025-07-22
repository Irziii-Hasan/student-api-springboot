package com.irzatech.studentapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.irzatech.studentapi.dto.StudentMapper;
import com.irzatech.studentapi.dto.StudentRequestDTO;
import com.irzatech.studentapi.dto.StudentResponseDTO;
import com.irzatech.studentapi.model.Student;
import com.irzatech.studentapi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
	public final StudentRepository studentRepository;
	
	public List<StudentResponseDTO> getAllStudents(){
		List<Student> student = studentRepository.findAll();
		return student.stream()
			.map(StudentMapper :: entityToDto)
			.toList();
	}
	
	public StudentResponseDTO saveStudent(StudentRequestDTO dto) {
		Student student = StudentMapper.dtoToEntity(dto);
		Student savedStudent = studentRepository.save(student);
		return StudentMapper.entityToDto(savedStudent);
	}
		
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
		Student student = studentRepository
				.findById(id).orElseThrow(()->new RuntimeException("Student not found with id= "+id));
		
//		update values
		student.setName(dto.getFullName());
		student.setAge(dto.getAge());
		student.setEmail(dto.getEmail());
		student.setDepartment(dto.getDepartment());
	    student.setRollNumber(dto.getRollNumber());
	    student.setGender(dto.getGender());
	    
		Student updatedStudent = studentRepository.save(student);	
		return StudentMapper.entityToDto(updatedStudent);
	}
	
	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Student not found with id: " + id));
		studentRepository.delete(student);
	}
	
	public StudentResponseDTO patchStudent(Long id, StudentRequestDTO dto) {
		Student student = studentRepository
				.findById(id).orElseThrow(()-> new RuntimeException("Student not found with id= "+id));
		
//		update student name if not empty
		if(dto.getFullName() != null) {
			student.setName(dto.getFullName());
		}
		
//		update student email if not empty
		if(dto.getEmail() != null) {
			student.setEmail(dto.getEmail());
		}
		
//		update student age if not 0
		if(dto.getAge() != 0) {
			student.setAge(dto.getAge());
		}
		
		if (dto.getDepartment() != null && !dto.getDepartment().isBlank()) {
	        student.setDepartment(dto.getDepartment());
	    }

	    if (dto.getRollNumber() != null && !dto.getRollNumber().isBlank()) {
	        student.setRollNumber(dto.getRollNumber());
	    }

	    if (dto.getGender() != null && !dto.getGender().isBlank()) {
	        student.setGender(dto.getGender());
	    }
		
		Student updatedStudent = studentRepository.save(student);
		return StudentMapper.entityToDto(updatedStudent);
	}
	
	
	
	
}
