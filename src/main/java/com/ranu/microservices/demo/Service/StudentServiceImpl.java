package com.ranu.microservices.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranu.microservices.demo.model.Student;
import com.ranu.microservices.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired 
	StudentRepo studentRepo;
	
	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student fatchById(long id) {
	Optional<Student> studentObj=	studentRepo.findById(id);
	if(studentObj.isPresent())
		return studentObj.get();
	else
		return null;
	}

}
