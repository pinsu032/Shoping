package com.uj;

public class FindMinMaxFromArray {

	public static void main(String[] args) {
		findMinMax();
	}
	
	public static void findMinMax() {
		int ar[] = {7,100,-5,1,24,-10}; // min = -10 , max = 100
		int max = ar[0];
		int min = ar[0];
		
		for(int i = 1 ; i<ar.length ; i++) {
			if(ar[i]>max)
				max = ar[i];
			if(ar[i]<min)
				min = ar[i];
		}
		System.out.println("Min:"+min+" "+"Max:"+max );
	}

}
