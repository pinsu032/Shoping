package com.uj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class CustomAnnotation {

	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		CustomAnnotation obj = new CustomAnnotation();
		Method method = obj.getClass().getMethod("printWish");
		System.out.println(method.getParameterCount());
		IntValue annotation = method.getAnnotation(IntValue.class);
		System.out.println(annotation.value());
	}
	
	@IntValue(10)
	 public void  printWish() {
		System.out.println("Good Morning");
	}

}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntValue{
	int value();
}

