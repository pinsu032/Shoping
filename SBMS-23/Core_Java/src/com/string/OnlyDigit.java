package com.string;

public class OnlyDigit {

	public static void main(String[] args) {

		String str = "123243121324132@#";
		
		System.out.println(isOnlyDigit(str));
	}
	
	private static boolean isOnlyDigit(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				flag = true;
			}else {
				return false;
			}
				
		}
		return flag;
		
	}

}
