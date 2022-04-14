package com.springwuelevateproject.praveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springwuelevateproject.praveen.model.Student;
import com.springwuelevateproject.praveen.services.StudentService;

@RestController
public class MyController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}

	// get the students
	@GetMapping("/students")
	public List<Student> getstudents() {

		return this.studentservice.getstudents();

	}

	// creating a get mapping that retrieves the detail of a specific student
	// this is an API
	@GetMapping("/students/{studentid}")
	public Student getstudents(@PathVariable("studentid") int studentid) {
		return studentservice.getstudentsById(studentid);
	}

	@PostMapping("/students")
	public Student saveBook(@RequestBody Student student) {
		studentservice.saveOrUpdate(student);
		return student;
	}

}
