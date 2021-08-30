package com.SeleniumProject.javaprogrammes;

public class ReverseStringEg {

	public static void main(String[] args) {
		
		String original = "dad"; // madam
		String rev = "";
//		int len = original.length();
		
		for (int i = original.length() - 1; i >= 0 ; i--) {
			
//			System.out.println(original.charAt(i));
			rev = rev + original.charAt(i); // muineleS
//			System.out.println(rev);
		}
		System.out.println("Final reversed string is : "+rev);
		
		if (original.equals(rev)) {
			System.out.println("Given string is polyndrome");
		}
		else
		{
			System.out.println("Given string is not a polyndrome");
		}
	}

}
