package com.uj.multithreading;

import java.util.concurrent.ExecutionException;

public class SynchronizationDemo implements Runnable{
	
	public synchronized void bookTicktes() {
//		if(availableTickets>0) {
//			System.out.println("Ticket bookes successfully.........");
//			availableTickets--;
//			System.out.println("Available Tickets :: "+availableTickets);
//		}
//		else {
//			System.out.println("Ticket not available...");
//		}
		
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+"=>"+i);
		}
			
	}
	 @Override
	public void run() {
		 bookTicktes();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SynchronizationDemo d = new SynchronizationDemo();
		Thread t1 = new Thread(d);
		Thread t2= new Thread(d);
		Thread t3 = new Thread(d);
         t1.start();
         t2.start();
         t3.start();
	}

}
