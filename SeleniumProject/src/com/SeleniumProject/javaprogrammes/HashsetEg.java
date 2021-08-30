package com.SeleniumProject.javaprogrammes;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetEg {

	public static void main(String[] args) {
		
		HashSet<Object> hs = new HashSet<Object>();
		
		hs.add("Selenium");
		hs.add("Apple");
		hs.add(900000);
		hs.add("Boll");
		
//		System.out.println(hs.size());
		
//		Iterator<Object> it = hs.iterator();
		
//		while(it.hasNext())
//		{
//			Object data = it.next();
//			System.out.println(data);
//		}
		
		for (Object data : hs) {
			System.out.println(data);
		}
	

	}

}
