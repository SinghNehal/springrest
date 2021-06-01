package com.springrest.springrest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class Mycontroller {
	@Autowired
	private CourseService courseservice;
	
	//to map 
	@GetMapping("/home")
	public String home(){
		return "Welcome to this application";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<courses> getCourses() {
		return this.courseservice.getCourses();
	}
	
	//get single course with id
	@GetMapping ("/courses/{courseId}")
	public courses getCourse(@PathVariable String courseId)
	{
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	//post new course
	@PostMapping("/courses")
	public courses addCourse(@RequestBody courses course)
	{
		return this.courseservice.addCourse(course);
	}
	
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deletecourse(@PathVariable String courseId) {
		try
		{
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
