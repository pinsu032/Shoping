package com.string;

public class PrintString {

	public static void main(String[] args) {
		String str = "Senior Associate Engineer";
		System.out.println(printString(str));
	}
	
	private static String printString(String str) {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		
		for(int i=1 ; i<=3;i++) {
			for(int j = 0; j<str.length();j++) {
				if(i==1) {
					if(!Character.isSpace(str.charAt(j))) {
						s1 = s1+ String.valueOf(str.charAt(j));
					}else {
						break;
					}
				}else if(i==2) {
					if(!Character.isSpace(str.charAt(j))) {
						s2 =s2+ String.valueOf(str.charAt(j));
					}else {
						break;
					}
				}else {
					if(!Character.isSpace(str.charAt(j))) {
						s3 =s3+ String.valueOf(str.charAt(j));
					}else {
						break;
					}
				}
			}
			break;
		}
		
		return s1+" "+s3+" "+s2;
	}

}
