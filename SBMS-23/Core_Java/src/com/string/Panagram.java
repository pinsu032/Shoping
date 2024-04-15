package com.string;

public class Panagram {
	
	public static void main(String[] args) {
		String str = "The quick brown fo jumps over the lazy dog";
		
		System.out.println(isPanagram(str));
	}
	
	private static  boolean isPanagram(String str) {
		boolean[] alphabetPresent = new boolean[26];
		
		str = str.toLowerCase();
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch>='a' && ch<='z') {
				alphabetPresent[ ch - 'a'] = true;
			}
		}
		
		
		for(boolean letterPresent : alphabetPresent) {
			if(!letterPresent) {
				return false ;
			}
		}
		
		return true;
	}

}
