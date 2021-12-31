package com.udemey.in28minutes.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
//		BinarySearchImpl binarySearchImpl=new BinarySearchImpl(new QuickSort());
		
//		System.out.println(result);

		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		int result=binarySearchImpl.binarySearch(new int[] {3,5,1,15}, 1);
		System.out.println(result);
	} 

}
