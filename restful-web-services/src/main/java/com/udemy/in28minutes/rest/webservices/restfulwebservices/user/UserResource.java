package com.udemy.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService daoService;
	//GET /users
	//retrieveAllUser
	
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return daoService.findAll();
	}
	//GET /users/{id}
	//retrieveUser(int id) 
	@GetMapping("/users/{id}")
	public User retrieveOneUser(@PathVariable int id) {
		return daoService.findOne(id);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		User savedUser = daoService.save(user);
	}
}
