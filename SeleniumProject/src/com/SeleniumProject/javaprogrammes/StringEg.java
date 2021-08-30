package com.SeleniumProject.javaprogrammes;

public class StringEg {

	public static void main(String[] args) {
		
		String course = "    Sel  en  ium   ";
		
//		System.out.println(course.toUpperCase());
//		System.out.println(course.toLowerCase());
//		
//		System.out.println(course.length());
//		
//		System.out.println(course.charAt(4));
//		System.out.println(course.indexOf('e'));
//		
//		System.out.println(course.lastIndexOf('e'));
//		
//		System.out.println(course.contains("len"));
//		System.out.println(course.equalsIgnoreCase("selenium"));
//		
//		System.out.println(course.replace('e', 'x'));
//		System.out.println(course.replaceFirst("e", "y"));
//		
//		System.out.println(course.concat(" is an automation tool"));
//		System.out.println(course + " is an automation tool");
//		System.out.println(course.join("&", course, "is","an","automation","tool"));
//		
//		System.out.println(course.valueOf(2000));
//		System.out.println(course.isEmpty());
//		
//		System.out.println(course.endsWith("iumbos"));
//		System.out.println(course.startsWith("Sel"));
//		
//		System.out.println(course.substring(2, 6));
		
//		System.out.println(course.trim());
		
		String x = "I am learning Selenium";
		
		String[] split = x.split(" ");
		
		System.out.println(split.length);
		
		for (String data : split)
		{
			System.out.println(data);
		}
	}

}
