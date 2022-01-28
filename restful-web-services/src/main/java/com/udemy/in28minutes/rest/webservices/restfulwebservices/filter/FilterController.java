package com.udemy.in28minutes.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	@GetMapping("/filterning")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("v1", "v2", "v3");
	}

	@GetMapping("/filterning-list")
	public List<SomeBean> retrieveListSomeBean() {
		return Arrays.asList(new SomeBean("v11", "v22", "v33"), new SomeBean("v1", "v2", "v3"));
	}
}
