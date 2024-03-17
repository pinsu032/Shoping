package com.uj.functionalinterface;

import java.util.function.Supplier;

public class SuplierDemo {

	public static void main(String[] args) {
		
		Supplier<String> suplier = () -> {
			String otp = "";
			for(int i = 1; i<=4;i++) {
				otp = otp + (int) (Math.random() * 10);
			}
			return otp;
		};
		
		System.out.println(suplier.get());
	}

}
