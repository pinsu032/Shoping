package com.uj;

public class SumOfGivenDigit {
	
	public static void main(String ...args) {
		String num = "123";
		System.out.println("First Approach===================");
		int number = Integer.parseInt(num);
		int sum =0;
		int arr[] = new int[3];
		for(int i=0;i<arr.length;i++) {
			arr[i]=number%10;
			sum = sum + arr[i];
			number = number / 10;
			System.out.println(arr[i]);
		}
		System.out.println("Sum given digits:::"+sum);
		
		System.out.println("Second Approach================");
		sum = 0;
		for(int i=0;i<num.length();i++) {
			char ch = num.charAt(i);
			sum = sum + ch-48;//subtract 48 from ascii value of given character
			//sum = sum + Character.getNumericValue(ch);
		}
		System.out.println("Sum given digits:::"+sum);
		
	}
	

}
