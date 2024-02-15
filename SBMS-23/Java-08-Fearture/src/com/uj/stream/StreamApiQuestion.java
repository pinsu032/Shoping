package com.uj.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import com.uj.model.Employee;

public class StreamApiQuestion {

	private static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
         saveEmployeeInList();
         //1. How many male and female employees are there in the organization ?
         // first approach
         long male = employeeList.stream().filter(i -> i.getGender().equalsIgnoreCase("Male")).count();
         long female = employeeList.stream().filter(i -> i.getGender().equalsIgnoreCase("Female")).count();
         
         System.out.println("Male Employee::"+male+"\nFemale Employee::"+female);
         
         //second approach
         Map<String, Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
         for(Entry<String, Long> entry : map.entrySet()) {
        	 System.out.println(entry.getKey()+"-"+entry.getValue());
         }
         //System.out.println(map);
         System.out.println("===============================");
         // 2. Print the name of all departments in the organization ?
         Map<String, Long> depMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
         //System.out.println(depMap);
          employeeList.stream()
                                    .map(Employee::getDepartment)
                                    .distinct()
                                    .forEach(name -> System.out.println(name));
          
          System.out.println("==================================");
          // 3. What is the average age of male and female employees ?
         Map<String, Double> avgMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
         System.out.println(avgMap);
         
         System.out.println("==================================");
         //4. Get the details of highest paid employee in the organization ?

         Optional<Employee> max = employeeList.stream().max(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary()>o2.getSalary())
					return +1;
				return -1;
			}
		});
         
         if(max.isPresent())
        	 System.out.println(max.get());
         else
        	 System.out.println("Nothing found..");
         
         Optional<Employee> collect = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
         if(collect.isPresent())
        	 System.out.println(collect.get());
         else
        	 System.out.println("Nothing found..");
         
         
         System.out.println("==================================");
         //5. Get the names of all employees who have joined after 2015 ?
			employeeList.stream()
			        .filter(e -> e.getYearOfJoining() > 2015)
			        .map(e -> e.getName())
					.forEach(names -> System.out.println(names));

	         System.out.println("==================================");
        //6. Count the number of employees in each department ?
	         Map<String, Long> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));
	         System.out.println(collect2);
	         
	         System.out.println("==================================");
        // 7. What is the average salary of each department ?
               Map<String, Double> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.averagingDouble(Employee::getSalary)));
               System.out.println(collect3);
               
  	         System.out.println("==================================");
            //8. Get the details of youngest male employee in the Development department ?
           Optional<Employee> collect4 = employeeList.stream().filter(e ->e.getGender().equalsIgnoreCase("Male") && e.getDepartment().equalsIgnoreCase("Development"))
                                                      .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
           
           if(collect4.isPresent())
        	   System.out.println(collect4.get());
           else
        	   System.out.println("Nothing found::");
           
	         System.out.println("==================================");
           //9. Who has the most working experience in the organization ?
           Optional<Employee> min = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
           if(min.isPresent())
        	   System.out.println(min.get());
           else
        	   System.out.println("Nothing found::");
           
	         System.out.println("==================================");
           //10. How many male and female employees are there in the Sales team ?
           Map<String, Long> collect5 = employeeList.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales")).collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
	         System.out.println(collect5);
	}

	private static void saveEmployeeInList() {        
		employeeList.add(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
		employeeList.add(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
		employeeList.add(new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
		employeeList.add(new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
		employeeList.add(new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
		employeeList.add(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
		employeeList.add(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
		employeeList.add(new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
		employeeList.add(new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
		employeeList.add(new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
		employeeList.add(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
		employeeList.add(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));
	}
}
