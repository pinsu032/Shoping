package com.uj;

public class MainClass {
	
	public static void main(String ...args) {
		Bus bus = new Bus();
		bus.systemCheck();
		bus.start();
		
		Car car = new Car();
		car.systemCheck();
		car.start();

		
		Truck truck = new Truck();
		truck.systemCheck();
		truck.start();

	}
}
