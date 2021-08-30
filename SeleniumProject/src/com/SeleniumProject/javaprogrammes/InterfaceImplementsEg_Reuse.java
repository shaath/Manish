package com.SeleniumProject.javaprogrammes;

public class InterfaceImplementsEg_Reuse {

	public static void main(String[] args) {
		InterfaceEg iie1 = new InterfaceImplementsEg1();
		
		iie1.Ship();
		
		InterfaceEg iie2 = new InterfaceImplementsEg2();
		iie2.flight();
	}
}
