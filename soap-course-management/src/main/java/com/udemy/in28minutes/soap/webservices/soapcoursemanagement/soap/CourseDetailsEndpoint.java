package com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.udemy.in28minutes.courses.CourseDetails;
import com.udemy.in28minutes.courses.GetCourseDetailsRequest;
import com.udemy.in28minutes.courses.GetCourseDetailsResponse;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	private CourseDetailsService service; 
	//request-> GetCourseDetailsRequest
	//Response-> GetCourseDetailsResponse
	//namespace-> 
	//name->GetCourseDetailsRequest
	@PayloadRoot(namespace = "http://in28minutes.udemy.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest courseDetailsRequest) {
		Course course = service.findById(courseDetailsRequest.getId());
		return mapCourse(course);
	}
	private GetCourseDetailsResponse mapCourse(Course course) {
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		CourseDetails courseDetails=new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return response;
	}

}
