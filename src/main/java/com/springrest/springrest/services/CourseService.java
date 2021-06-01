package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.courses;

public interface CourseService {
	public List<courses> getCourses();
	public courses getCourse(long courseId);
	public courses addCourse(courses course);
	public void deleteCourse(long courseId);
}
