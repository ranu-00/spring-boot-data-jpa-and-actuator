package com.ranu.microservices.demo.Service;

import com.ranu.microservices.demo.model.Student;

public interface StudentService {

	Student save (Student student);
	
	Student fatchById(long id);
}
