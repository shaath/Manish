package com.SeleniumProject.javaprogrammes;

public class StaticArrayEg {

	public static void main(String[] args) {
		
		Object[] course = {"UFT", "Python", "Java","TypeScript", "Perl", 4000, 'M'};		
		System.out.println(course.length);
		
//		System.out.println(course[3]);
		
		for(int i = 0; i < course.length; i++)
		{
			System.out.println(course[i]);
		}
	}

}
