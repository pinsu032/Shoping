package com.uj;

public class Bus implements Vehicle {
	
	@Override
	public void systemCheck() {
		System.out.println("Bus system check started:::::::");
	}

	@Override
	public void start() {
         System.out.println("Bus started::::::::::::::::");
	}

}
