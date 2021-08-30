package com.SeleniumProject.javaprogrammes;

public class DynamicArrayEg {

	public static void main(String[] args) {
		
		int[] salary = new int[5];
		
		System.out.println(salary.length);
		
//		System.out.println(salary[2]);
		
		salary[1] = 60000;
		salary[3] = 87000;
		salary[1] = 100000;
		
//		for (int i = 0; i < salary.length; i++) {
//			System.out.println(salary[i]);
//		}
		
		for (int data : salary)
		{
			System.out.println(data);
		}
		
	}

}
