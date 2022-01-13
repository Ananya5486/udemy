package com.udemy.in28minutes.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Spring Configuration
@Configuration
//Enable spring web services
@EnableWs
public class WebServiceConfig {
//MessageDispatcherServlet
	// ApplicationContext
	// Url->/ws*

	@Bean
	ServletRegistrationBean bean(ApplicationContext context) {
		// Map MessageDispatcherServlet-> /ws/*
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	// url-> /ws/courses.wsdl
	//portType-> coursePort
	//Namespce-> http://in28minutes.udemy.com/courses
	//course-details.xsd
	@Bean(name = "courses")
	public DefaultWsdl11Definition definition(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition =new DefaultWsdl11Definition();
		//portType-> coursePort
		wsdl11Definition.setPortTypeName("coursePort");
		//Namespce-> http://in28minutes.udemy.com/courses
		wsdl11Definition.setTargetNamespace("http://in28minutes.udemy.com/courses");
		// url-> /ws/
		wsdl11Definition.setLocationUri("/ws");	
		//schema
		wsdl11Definition.setSchema(schema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

}
