package com.ranu.microservices.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranu.microservices.demo.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    @SuppressWarnings("unchecked")
	Student save(Student student);	
	
}
