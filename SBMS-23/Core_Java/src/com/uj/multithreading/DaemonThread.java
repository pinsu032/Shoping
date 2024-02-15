package com.uj.multithreading;

public class DaemonThread{

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {	
			int count =1;
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					count++;
					if (Thread.currentThread().isDaemon())
						System.out.println("Daemon Thread running......"+count);
					else
						System.out.println("Normal Thread running.."+count);
				}
			}
		});
		t.setDaemon(true);
		t.start();
		int c=1;
		for (int i = 1; i <= 80; i++) {
			c++;
			System.out.println(c);
		}
	}
		
}
