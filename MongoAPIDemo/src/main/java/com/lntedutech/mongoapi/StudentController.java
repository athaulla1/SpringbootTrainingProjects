package com.lntedutech.mongoapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lntedutech.mongoapi.collection.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository srepo;
	
	
	@PostMapping("/addstudent") 
	public ResponseEntity<Student> addStudent(@RequestBody Student stud)
	{
		srepo.save(stud);
		return new ResponseEntity<Student>(stud,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
	    return srepo.findAll();
	 }
	
}
