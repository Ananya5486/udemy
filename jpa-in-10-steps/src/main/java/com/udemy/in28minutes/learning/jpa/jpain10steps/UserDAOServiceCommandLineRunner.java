package com.udemy.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.udemy.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;
import com.udemy.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

	@Autowired
	private UserDAOService daoService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Ananya", "Admin");
		long insert = daoService.insert(user);
		LOGGER.info("new user created" + user);

	}

}


