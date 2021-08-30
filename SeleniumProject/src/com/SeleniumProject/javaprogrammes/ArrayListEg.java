package com.SeleniumProject.javaprogrammes;

import java.util.ArrayList;

public class ArrayListEg {

	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add("Selenium");
		list.add(90000);
		list.add(2, 'M');
		list.add(0,"Manish");
		
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
		}
		
	}

}
