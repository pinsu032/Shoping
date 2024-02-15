package com.uj.comparator;

import java.util.Comparator;

import com.uj.model.Employee;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if( o1.getSalary() > o2.getSalary())
			return +1;
		return -1;
	}

}
