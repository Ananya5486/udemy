package com.udemy.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService daoService;
	// GET /users
	// retrieveAllUser

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return daoService.findAll();
	}

	// GET /users/{id}
	// retrieveUser(int id)
	@GetMapping("/users/{id}")
	public User retrieveOneUser(@PathVariable int id) {
		User user = daoService.findOne(id);
		if (null == user)
			throw new UserNotFoundException("id-" + id);
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = daoService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
