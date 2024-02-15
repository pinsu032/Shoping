package com.uj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

}


