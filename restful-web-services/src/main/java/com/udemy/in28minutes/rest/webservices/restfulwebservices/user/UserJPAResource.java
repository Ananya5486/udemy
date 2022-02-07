package com.udemy.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService daoService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	// GET /users
	// retrieveAllUser

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUser() {
		List<User> findAll = userRepository.findAll();
		if (null == findAll) {
			throw new UserNotFoundException("No user found");
		}
		return findAll;
	}

//retrieving posts of a user
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUser(@PathVariable int id) {
		Optional<User> findAll = userRepository.findById(id);
		if (!findAll.isPresent()) {
			throw new UserNotFoundException("No user found" + id);
		}

		return findAll.get().getPost();
	}

	// GET /users/{id}
	// retrieveUser(int id)
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("No user found" + id);
		}
		// HATEOAS
		EntityModel<User> resource = EntityModel.of(user.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		if (null == savedUser.getName()) {
			throw new NameNotFoundExeption("Name cannot be null");
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	//creating posts for a  user
	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<Object> addPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> savedUser = userRepository.findById(id);
		if (!savedUser.isPresent()) {
			throw new UserNotFoundException("No user found" + id);
		}
		User user = savedUser.get();
		post.setUser(user);
		postRepository.save(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteOneUser(@PathVariable int id) {
		userRepository.deleteById(id);
//		if (null == user)
//			throw new UserNotFoundException("id-" + id);
	}
}
