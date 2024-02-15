package com.uj.functionalinterface;

import java.util.function.Predicate;

public class PredicateTest {
	
	public static void main(String ...args) {
		String[ ]  names = {"Anushka", "Anupama", "Deepika", "Kajol", "Sunny" };
		
		for (int i = 0; i < names.length; i++) {
			Predicate<String> p = name -> name.startsWith("A");
			if(p.test(names[i]))
			System.out.println(names[i]);
		}
	}

}
