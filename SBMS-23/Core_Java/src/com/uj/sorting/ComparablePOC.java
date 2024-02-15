package com.uj.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparablePOC {

	public static void main(String[] args) {

		//List<Student> list = List.of(new Student(103,"ujjawal",1),new Student(102,"pinsu",2),new Student(101,"raju",3));
		List<Student> st = new ArrayList<>();
		st.add(new Student(103,"ujjawal",1));
		st.add(new Student(101,"pinsu",2));
		st.add(new Student(102,"raju",3));
		Collections.sort(st);
		//System.out.println(st);
		st.forEach(s -> System.out.println(s));
	
	}

}

class Student implements Comparable<Student> {

	int id;
	String name;
	int rank;

	public Student(int id, String name, int rank) {
		this.id = id;
		this.name = name;
		this.rank = rank;
	}


	@Override
	public int compareTo(Student s) {
		//return this.rank - s.rank;
		return this.name.compareTo(s.name);
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}


}
 
