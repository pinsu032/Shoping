package com.uj;

import java.util.Arrays;

public class FindMissingNumberFromArray {

	public static void main(String[] args) {
		findMissingNumber();
	}
	
	public static void findMissingNumber() {
		
		int ar[] = {1,5,7,4,3,2,10,9,6};
	    Arrays.sort(ar); //{1,2,3,5,6,7,8,9,10}
		int missingNumber = 0;
		int count = 1 ;
		for(int i = 0;i<ar.length;i++) {
			if(ar[i] == count) {
				count++;
				continue;
			}
			else {
				count++;
				missingNumber = ar[i]-1;
				break;
			}
				
		}
		System.out.println("Missing Number "+missingNumber);

		//2nd approach
		int n = 10;
		int sum = n*(n+1)/2;//sum of n natural number
		int sumarr=0;
		for(int i=0;i<ar.length;i++) {
			sumarr = sumarr+ar[i];
		}
		
		missingNumber = sum - sumarr;
		
		
		System.out.println("Missing Number "+missingNumber);
	}

}
