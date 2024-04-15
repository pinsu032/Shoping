package com.string;

public class ReverseString {

		public static void main(String[] args) {
			String str = "  This    is   java   project  ";
			System.out.println(reverseString(str).replaceAll("\\s+", " "));
		}
		
		private static String reverseString(String str) {
			StringBuilder reversedString = new StringBuilder();
			
			for(int i = str.length() - 1; i>=0; i--) {
				reversedString.append(str.charAt(i));
			}
			return reversedString.toString();
		}

}
