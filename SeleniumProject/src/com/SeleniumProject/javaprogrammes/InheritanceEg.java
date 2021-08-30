package com.SeleniumProject.javaprogrammes;

public class InheritanceEg extends MethodEg{

	public static void main(String[] args) {
		
		function1();
		MethodEg me = new MethodEg();
		int res = me.sum(40, 30, 30);
		System.out.println(res);
		
		me.function1();
		
	}
	
	public static void function1(){
		System.out.println("This is InheritanceEg function1 code");
	}
}
