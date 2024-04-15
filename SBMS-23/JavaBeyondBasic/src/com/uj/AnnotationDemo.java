package com.uj;

import java.util.ArrayList;

public class AnnotationDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Animal a = new Dog();
		a.eatSomething();
		
		
		ArrayList al = new ArrayList();
		
		
		
	}

}

class Animal{
	@Deprecated
	void eatSomething() {
		System.out.println("eating something");
	}
}

class Dog extends Animal{
	@Override
	void eatSomething() {
		System.out.println("eating food");
	}
}
