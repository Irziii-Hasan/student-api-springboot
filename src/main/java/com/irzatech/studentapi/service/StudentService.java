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
	
	
}
