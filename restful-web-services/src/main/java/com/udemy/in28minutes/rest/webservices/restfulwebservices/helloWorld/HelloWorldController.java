package com.udemy.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	// GET
	// URI->/helloWorld
	// method "hello world
	@Autowired
	private MessageSource messageSource;
//	@RequestMapping(method = RequestMethod.GET,path = "/helloWorld")
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	///hello-world/path-variable/in28minutes
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}

	@GetMapping("/hello-world-internationalization")
	public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language",required = false) Locale locale ) {
		return messageSource.getMessage("good.morning.message", null,locale);
	}

}
