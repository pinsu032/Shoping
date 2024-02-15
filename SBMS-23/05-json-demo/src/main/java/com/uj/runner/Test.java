package com.uj.runner;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uj.model.Author;
import com.uj.model.Book;

@Component
public class Test implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

//		Author athr = new Author();
//		athr.setAuthorEmail("pinsu@gmail.com");
//		athr.setAuthorName("Pinsu");
//		athr.setAuthorPhno(99999999l);
//		
//		Book book = new Book();
//		book.setAuthor(athr);
//		book.setId(101);
//		book.setName("Core-java");
		
		//converting java object to json (serialization)
    	ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(new File("book.json"), book);
		
		
		//converting json to java object
		Book readValue = mapper.readValue(new File("book.json"), Book.class);
		System.out.println(readValue);
		System.out.println("Conversion completed.........");
		
	}

}
