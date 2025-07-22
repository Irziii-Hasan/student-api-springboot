package com.irzatech.studentapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irzatech.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByName(String fullName);
	
	public List<Student> findByDepartment(String department);

	public List<Student> findByNameAndDepartment(String fullName, String department);

}
