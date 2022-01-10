package com.udemey.in28minutes.springBoot.basics.springBootin10minutes;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(11,"harry potter2","potter"));
	}

}
