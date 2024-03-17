package com.uj.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	
	public static void main(String ...args) {
//		String[ ]  names = {"Anushka", "Anupama", "DeepikA", "Kajol", "Sunny" };
//		
//		 Arrays.asList(names).forEach(name -> {
//			 Predicate<String> p1= n -> n.charAt(0) == 'A';
//			 if(p1.test(name))
//				 System.out.println("Name started with A is "+name);
//		 });
		
		// Print emp names who are working in "Hyd" location in "DB team".
		Employee e1 = new Employee("Anil", "Chennai", "DevOps");
		Employee e2 = new Employee("Rani", "Pune", "Networking");
		Employee e3 = new Employee("Ashok", "Hyd", "DB");
		Employee e4 = new Employee("Ganesh", "Hyd", "DB");

		List<Employee> emps = Arrays.asList(e1, e2, e3, e4);
		Predicate<Employee> locationPdct = emp -> emp.location.equalsIgnoreCase("hyd");
		Predicate<Employee> teamPdct = emp -> emp.dept.equalsIgnoreCase("DB");
		Predicate<Employee> and = locationPdct.and(teamPdct);

		emps.forEach(employee -> {
			  if(and.test(employee) )
				  System.out.println(employee.name);
		});
	}

}

class Employee {

	String name;
	String location;
	String dept;

	Employee(String name, String location, String dept) {
		this.name = name;
		this.location = location;
		this.dept = dept;
	}
}


