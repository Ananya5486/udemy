package com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.udemy.in28minutes.courses.CourseDetails;
import com.udemy.in28minutes.courses.DeleteRequest;
import com.udemy.in28minutes.courses.DeleteResponse;
import com.udemy.in28minutes.courses.GetAllCourseDetailsRequest;
import com.udemy.in28minutes.courses.GetAllCourseDetailsResponse;
import com.udemy.in28minutes.courses.GetCourseDetailsRequest;
import com.udemy.in28minutes.courses.GetCourseDetailsResponse;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.exception.CourseNotFoundException;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	private CourseDetailsService service;

	// request-> GetCourseDetailsRequest
	// Response-> GetCourseDetailsResponse
	// namespace->
	// name->GetCourseDetailsRequest
	@PayloadRoot(namespace = "http://in28minutes.udemy.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(
			@RequestPayload GetCourseDetailsRequest courseDetailsRequest) {
		Course course = service.findById(courseDetailsRequest.getId());
		if(course==null)
			throw new CourseNotFoundException("Invalid course id "+courseDetailsRequest.getId());
		return mapCourseDetails(course);
	}
	@PayloadRoot(namespace = "http://in28minutes.udemy.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest courseDetailsRequest) {
		List<Course> courses = service.findAll();
		return mapAllCourseDetails(courses);
	}
	@PayloadRoot(namespace = "http://in28minutes.udemy.com/courses", localPart = "DeleteRequest")
	@ResponsePayload
	public DeleteResponse deleteCourseDetailsRequest(
			@RequestPayload DeleteRequest deleteRequest) {
		DeleteResponse deleteResponse=new DeleteResponse();
		Status deleteById = service.deleteById(deleteRequest.getId());
		deleteResponse.setStatus(mapStatus(deleteById));
		return deleteResponse;
	}
	private com.udemy.in28minutes.courses.Status mapStatus(Status deleteById) {
		if(deleteById==Status.FAILURE)
			return com.udemy.in28minutes.courses.Status.FAILURE;
		return com.udemy.in28minutes.courses.Status.SUCCESS;
	}
	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Course course : courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

	

}
