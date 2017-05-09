package com.common;

public class graphTest {

	public static void main(String[] args) {
	
//		graphMethod gm=new graphMethod();
//		gm.initialVetex();
//		gm.search();
		FloydMethods fm=new FloydMethods();
		fm.initialData();
		fm.findPath();
		fm.printPtah();

	}

}
