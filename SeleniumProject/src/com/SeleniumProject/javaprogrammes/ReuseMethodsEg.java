package com.SeleniumProject.javaprogrammes;

public class ReuseMethodsEg {

	public static void main(String[] args) {
		
		MethodEg me = new MethodEg();
		
		String res = me.function2();
		System.out.println(res);
		
		int sumRes = me.sum(600, 400);
		System.out.println(sumRes);
		
		sumRes = me.sum(60, 40, 50);
		System.out.println(sumRes);
	}

}
