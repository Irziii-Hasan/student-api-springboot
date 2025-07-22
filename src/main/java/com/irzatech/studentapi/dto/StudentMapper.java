package com.irzatech.studentapi.dto;

import com.irzatech.studentapi.model.Student;

public class StudentMapper {

//	to convert Room DTO into Room entity class
	public static Student dtoToEntity(StudentRequestDTO dto) {
		return Student.builder()
				.name(dto.getFullName())
				.age(dto.getAge())
				.department(dto.getDepartment())
				.email(dto.getEmail())
				.gender(dto.getGender())
				.rollNumber(dto.getRollNumber())
				.build();
	}
	
//	to convert Room entity into DTO class
	public static StudentResponseDTO entityToDto(Student student) {
		StudentResponseDTO dto = new StudentResponseDTO();
	    dto.setId(student.getId());
		dto.setFullName(student.getName());
		dto.setAge(student.getAge());
		dto.setDepartment(student.getDepartment());
		dto.setEmail(student.getEmail());
		dto.setGender(student.getGender());
		dto.setRollNumber(student.getRollNumber());
		return dto;
	}
	

}
