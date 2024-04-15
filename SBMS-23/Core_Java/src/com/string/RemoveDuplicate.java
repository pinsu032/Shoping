package com.string;

public class RemoveDuplicate {

	public static void main(String[] args) {

		String str = "hello";
		System.out.println(removeDuplicate(str));
	}
	
	private static String removeDuplicate(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<str.length();i++) {
			if(sb.indexOf(String.valueOf(str.charAt(i))) == -1){
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString();
	}

}
