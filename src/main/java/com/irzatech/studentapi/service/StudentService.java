package com.irzatech.studentapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.irzatech.studentapi.model.Student;
import com.irzatech.studentapi.repository.StudentRepository;

@Service
public class StudentService {
	public final StudentRepository studentRepository;
	
//	@RequiredArgsConstructor (for auto-generate constructor we use this annotation)
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long id, Student updatedStudent) {
		Student existingStudent = studentRepository
				.findById(id).orElseThrow(()->new RuntimeException("Student not found with id= "+id));
		
//		update values
		existingStudent.setName(updatedStudent.getName());
		existingStudent.setAge(updatedStudent.getAge());
		existingStudent.setEmail(updatedStudent.getEmail());
		
		return studentRepository.save(existingStudent);	
	}
	
	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Student not found with id: " + id));
		studentRepository.delete(student);
	}
	
	public Student patchStudent(Long id, Student updateData) {
		Student existingStudent = studentRepository
				.findById(id).orElseThrow(()-> new RuntimeException("Student not found with id= "+id));
		
//		update student name if not empty
		if(updateData.getName() != null) {
			existingStudent.setName(updateData.getName());
		}
		
//		update student email if not empty
		if(updateData.getEmail() != null) {
			existingStudent.setEmail(updateData.getEmail());
		}
		
//		update student age if not 0
		if(updateData.getAge() != 0) {
			existingStudent.setAge(updateData.getAge());
		}
		
		if (updateData.getDepartment() != null && !updateData.getDepartment().isBlank()) {
	        existingStudent.setDepartment(updateData.getDepartment());
	    }

	    if (updateData.getRollNumber() != null && !updateData.getRollNumber().isBlank()) {
	        existingStudent.setRollNumber(updateData.getRollNumber());
	    }

	    if (updateData.getGender() != null && !updateData.getGender().isBlank()) {
	        existingStudent.setGender(updateData.getGender());
	    }
		
		return studentRepository.save(existingStudent);
	}
	
	
}
