package com.uj;

public class Truck implements Vehicle {
	
	@Override
	public void systemCheck() {
		System.out.println("Truck system check started:::::::");
	}

	@Override
	public void start() {
         System.out.println("Truck started::::::::::::::::");
	}

}
