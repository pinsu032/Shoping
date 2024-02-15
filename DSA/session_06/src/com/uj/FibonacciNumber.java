package com.uj;

public class FibonacciNumber {

	public static void main(String[] args) {

		Integer arr[] = new Integer[8];
		// 0 1 1 2 3 5 8 13 
		int a=0;
		int b=1;
		for(int i = 0; i<7; i++) {
		    arr[i]=a;
		    arr[i+1]=b;
			int c = a+b;
			a=b;
			b=c;
			
		}
		for(Integer i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

}
