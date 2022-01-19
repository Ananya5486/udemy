package com.udemy.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	//GET
	//URI->/helloWorld
	//method "hello world 	 
	
//	@RequestMapping(method = RequestMethod.GET,path = "/helloWorld")
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

}