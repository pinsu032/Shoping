package com.uj;

public class Car implements Vehicle {
	
	@Override
	public void systemCheck() {
		System.out.println("Car system check started:::::::");
	}

	@Override
	public void start() {
         System.out.println("Car started::::::::::::::::");
	}

}
