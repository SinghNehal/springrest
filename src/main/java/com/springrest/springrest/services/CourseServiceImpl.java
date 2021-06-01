package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.courses;
@Service
public class CourseServiceImpl implements CourseService{
	List <courses> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new courses(145,"Java Core Course"," This couse Contains basics on Java"));
		list.add(new courses(1454,"Spring Boot Course"," Creating rest api using spring boot"));

	}
	@Override
	public List<courses> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public courses getCourse(long courseId) {
		// TODO Auto-generated method stub
		courses c =null;
		for(courses course :list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public courses addCourse(courses course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		
		
	}
	

}
