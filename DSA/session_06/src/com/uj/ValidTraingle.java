package com.uj;

public class ValidTraingle {

	public static void main(String[] args) {

		int ar[]= {10,1,8};
		int max = 0;
		int sum = 0;
		for(int i=0;i<3;i++) {
			if(ar[i]>max)
				max = ar[i];
			
			sum = sum + ar[i];
		}
		
		int sumOfTwoLowestNumber = sum - max ;
		if(sumOfTwoLowestNumber>max)
			System.out.println("Valid Traingle");
		else
			System.out.println("Invalid Traingle");
		
	}

}
