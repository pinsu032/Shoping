package com.uj;

public interface Vehicle{
	public default void systemCheck() {
		System.out.println("System check started....");
	}
	void start();
}