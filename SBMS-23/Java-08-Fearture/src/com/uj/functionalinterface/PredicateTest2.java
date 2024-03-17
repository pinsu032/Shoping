package com.uj.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
	
	public static void main(String ...args) {
		List<Person> of = Arrays.asList(new Person(23,"Niraj"),new Person(17,"Raju"),new Person(15,"Sam"));
		
		of.forEach(person -> {
			  Predicate<Person> p = per ->  per.age>= 18;
			  if(p.test(person))
				  System.out.println("Person eligible for voting "+person.name);
		});
	}

}

class Person{
	Integer age;
	String name;
	
	public Person(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	
}
