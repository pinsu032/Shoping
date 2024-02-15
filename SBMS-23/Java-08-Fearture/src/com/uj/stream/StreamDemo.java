package com.uj.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("india","usa","uk", "japan");
		
		names.stream().map(name -> name.toUpperCase()).forEach(n -> System.out.println(n));
		
		names.stream().mapToInt(name -> name.length()).forEach(i -> System.out.println(i));
		
		System.out.println("=============================================");
		
		List<String> list = Arrays.asList("Ashok", "Anil", "Raju", "Rani", "John", "Akash", "Charles");
		// print name with its length which are starting with 'A' using Stream API
		//Ashok - 5
		//Anil  - 4
		//Akash - 5
		
		list.stream().filter(nam -> nam.startsWith("A"))
		.map(name -> name+"-"+name.length())
		.forEach(n -> System.out.println(n));
		
		System.out.println("=============================================");

		List<String> javacourses = Arrays.asList("core java", "adv java", "springboot");

		List<String> uicourses = Arrays.asList("html", "css", "bs", "js");

		List<List<String>> courses = Arrays.asList(javacourses, uicourses);
		
		//courses.stream().forEach(c -> System.out.println(c));
		
		Stream<String> fms = courses.stream().flatMap(s -> s.stream());
		
		fms.forEach(c -> System.out.println(c));

	}

}
