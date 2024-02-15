package com.uj.multithreading;

public  class Demo implements Runnable{

	@Override
	public void run() {
		System.out.println("run() method started:"+Thread.currentThread().getName());
		try {
			Thread.sleep(15000); //blocked state
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("run() method ended:"+Thread.currentThread().getName());

	}
	public static void main(String[] args) {
		Demo d = new Demo();
          Thread thread1 = new Thread(d);
          thread1.setPriority(Thread.MAX_PRIORITY);//10
          thread1.setName("Thread-1");
          
          Thread thread2 = new Thread(d);
          thread1.setPriority(Thread.NORM_PRIORITY);//5
          thread1.setName("Thread-2");
          
          Thread thread3 = new Thread(d);
          thread1.setPriority(Thread.MIN_PRIORITY);//1
          thread1.setName("Thread-3");
          
          thread1.start();
          thread2.start();
          thread3.start();
	}

}
