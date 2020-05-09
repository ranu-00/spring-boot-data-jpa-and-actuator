package com.ranu.microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranu.microservices.demo.Service.StudentService;
import com.ranu.microservices.demo.model.Student;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value ="/hello" ,method = RequestMethod.GET)
	public String getData() {		
		return "Hello from rest service";
	}
	
	@RequestMapping(value="/student" , method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentService.save(student);		
	}
	@RequestMapping(value="/student" , method = RequestMethod.GET)
	public ResponseEntity<Student> fatchStudent(@RequestParam Long id) {
		Student student = studentService.fatchById(id);
		if(student == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(student);
		
	}
}
