package com.uj.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {

		//1st Thread
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				Banking obj = new Banking();
				obj.deposite();
			}	
		};
		
		//1st Thread
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				Banking obj = new Banking();
				obj.withdraw();
			}
		};
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		th2.start();
		th1.start();
		/////////////////////////////////////////////////////////////////
		
		
	}

}

class Banking{
	
	public void deposite() {
		System.out.println("Deposite Successfull..");
	}
	
	public void withdraw() {
		System.out.println("Withdraw success..");
	}
}
