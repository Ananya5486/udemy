package com.udemey.in28minutes.springBoot.basics.springBootin10minutes;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootIn10MinutesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(SpringBootIn10MinutesApplication.class, args);
		for (String name : applicationContext.get) {
			
		}
	}

}
