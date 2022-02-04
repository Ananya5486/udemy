package com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {
	public enum Status{
		SUCCESS,FAILURE;
	}
	private static List<Course> course=new ArrayList<Course>();
	static {
		Course course1=new Course(1, "Spring", "10 Step");
		course.add(course1);
		
		Course course2=new Course(2, "Java", "5 Step");
		course.add(course2);
		
		Course course3=new Course(3, "MicroService", "20 Step");
		course.add(course3);
		
		Course course4=new Course(4, "Maven", "Popular build tool");
		course.add(course4);
	}
//course 1
	//Course findByid(int id)
	public Course findById(int id) {
		for (Course courses : course) {
			if(courses.getId()==id) 
				return courses;
		}
		return null;
	}
	
//AllCourses
	//List<Course> findAll()
	public List<Course> findAll(){
		return course;
	}
//delete
	//Course deleteById(int id)
	public Status deleteById(int id) {
		Iterator<Course> iterator = course.iterator();
		while (iterator.hasNext()) {
			 Course course2 = iterator.next();
			 if(course2.getId()==id) {
				 iterator.remove();
				 return Status.SUCCESS;
			 }
		}
		return Status.FAILURE;
	}
}
