package com.udemy.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.udemy.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Navya", "User");
		userRepository.save(user);
		LOGGER.info("new user created" + user);
		Optional<User> findById = userRepository.findById(1L);
		LOGGER.info("User is retrieved" + findById);
		List<User> findAll = userRepository.findAll();
		LOGGER.info("All users" + findAll);
		

	}

}
