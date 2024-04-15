package com.uj.io;

import java.util.Arrays;

public class StringDemo{

	public static void main(String[] args) {
		String str1 = "Pinsu";
		
		
		System.out.println(reverseString(str1));
		
		System.out.println("====================================");
		
		String str2 = "leve";
		System.out.println(isPalindrome(str2));
		
       System.out.println("====================================");
		
		String str3 = "UjjAwal";
		countVowelConsonenet(str3);
		
        System.out.println("====================================");
		
		String str4 = "listen";
		String str5 = "silent";
		
		System.out.println(isAnagrams(str4 , str5));;
		
		
	}
	
	public static boolean isAnagrams(String str1 , String str2) {
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		if(str1.length() != str2.length())
			return false;
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		return Arrays.equals(charArray1, charArray2);
	}
	
	public static void countVowelConsonenet(String str) {
		// vowels  a , e , i ,o u
		int vowelCount = 0 ;
		int consonent = 0;
		
		char[] charArray = str.toCharArray();
        for(char ch : charArray) {
        	if(ch == 97 || ch == 65  || ch == 69 || ch == 101 || ch == 73 || ch == 105 || ch == 111 || ch == 79 || ch == 85 || ch == 117 ) {
        		vowelCount++;
        	}
        	else {
        		consonent++;
        	}
        }
        System.out.println(vowelCount + " "+ consonent);
	}
	
	
	public static String reverseString(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder reverseString = new StringBuilder();
		for(int i = charArray.length-1 ; i>=0 ; i--) {
			reverseString.append(charArray[i]);
		}
		
		return reverseString.toString();
	}
	
	public static boolean isPalindrome(String str) {
		String reverseString = reverseString(str);
		
		if(str.equals(reverseString)) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
