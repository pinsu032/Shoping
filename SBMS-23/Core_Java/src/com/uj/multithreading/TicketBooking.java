package com.uj.multithreading;

public class TicketBooking {
	
	int availableTickets = 2;
	
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

}
