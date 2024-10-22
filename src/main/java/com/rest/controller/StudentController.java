package com.rest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Student;
import com.rest.services.StudentServices;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/std")
public class StudentController {
    
	@Autowired
	private StudentServices stdService;
	
	@GetMapping
	public List<Student> getAllStudent(){
		return stdService.getAllStudent();
	}
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(int id) {
		return stdService.getStudentById(id);
	}
	@PostMapping
	public Student createStudent(@RequestBody Student std) {
		return stdService.createStudent(std);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student std) {
		return stdService.updateStudent(id, std) ;
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
	       boolean isDeleted = stdService.deleteStudent(id);
	        return isDeleted ? "Student deleted successfully" : "Student not found";
	}
	
}
