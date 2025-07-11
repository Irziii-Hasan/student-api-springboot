package com.irzatech.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irzatech.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
