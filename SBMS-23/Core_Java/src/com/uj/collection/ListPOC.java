package com.uj.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class ListPOC {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		
		//iterating list using forEach method
		
		al.forEach(i -> System.out.println(i));
		
		// remove duplicate value from given array
		Integer ar[] = {5,3,3,4,1};
		Set<Object> s = new TreeSet<Object>(Arrays.asList(ar));
		s.forEach(i-> System.out.println(i));
		
		System.out.println("=====================");
		
		Set<Integer> lhs = new TreeSet<>();
		lhs.add(10);
		lhs.add(20);
		lhs.add(30);
		//lhs.add(null);
		lhs.add(40);
		lhs.add(20);

		System.out.println(lhs);
		
		System.out.println("=====================");
        
		TreeSet ts = new TreeSet();

		ts.add("raja");
		ts.add("raja");
		ts.add("rani");
		ts.add("ashok");

		System.out.println(ts); // ashok, raja, rani

		Iterator iterator = ts.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("======================");
		
		Map<Integer, String> map = new HashMap<>();

		map.put(101, "John");
		map.put(102, "Smith");
		map.put(103, "Orlen");
		map.put(102, "David");
		
		System.out.println(map);
		System.out.println(map.values());
		System.out.println(map.keySet());
		
		//first approach to iterate from map
		for(Integer key : map.keySet()) {
			System.out.println(key+"-"+map.get(key));
		}
		
		//second approach
		for(Entry<Integer, String>  entry : map.entrySet()) {
			System.out.println(entry.getKey()+"::"+entry.getValue());
		}
			System.out.println("==============================");
			// Properties class
			
			FileInputStream fis = new FileInputStream("src/database.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			String uname = prop.getProperty("uname");
			String password = prop.getProperty("password");
			
			System.out.println(uname+"::"+password);
		
	}

}
