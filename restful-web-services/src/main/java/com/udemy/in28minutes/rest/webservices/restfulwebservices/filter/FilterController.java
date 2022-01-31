package com.udemy.in28minutes.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	@GetMapping("/filterning")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("v1", "v2", "v3");
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}

	@GetMapping("/filterning-list")
	public MappingJacksonValue retrieveListSomeBean() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("v11", "v22", "v33"), new SomeBean("v1", "v2", "v3"));
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(asList);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}
}
