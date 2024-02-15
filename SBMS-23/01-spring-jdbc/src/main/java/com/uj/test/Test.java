package com.uj.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String removeDuplicate = removeDuplicate("pinsusingh");
		System.out.println("Duplicate Removed::::::"+removeDuplicate);
	}
	
	private static String removeDuplicate(String str) {
		// p i n s u s i n g h ==> p i n s u g h
		char[] charArray = str.toCharArray();
	    Set<Character> charSet = new LinkedHashSet<>();
	    for(char c : charArray) {
	    	charSet.add(c);
	    }
	    StringBuilder rmvSb = new StringBuilder();
	    for(char c : charSet) {
	    	rmvSb.append(c);
	    }
		return rmvSb.toString();
	}

}
