package com.uj.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterServiceDemo  implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		System.out.println("call() method executed...");
		System.out.println(Thread.currentThread().getName());
		return "success";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecuterServiceDemo demo = new ExecuterServiceDemo();
		ExecutorService exService = Executors.newFixedThreadPool(3);
		for(int i = 1 ; i<=5;i++) {
			Future<Object> submit = exService.submit(demo);
			System.out.println(submit.get().toString());
		}
		exService.shutdown();
	}

}
