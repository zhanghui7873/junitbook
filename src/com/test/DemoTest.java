package com.test;

public class DemoTest {
  
	public static void main(String[] args) {
		int i = 0;
		i=i+1;
		String str="world";
		char ch[]={'h','e','l','l','0'};
		DemoTest.change(str, ch);
		System.out.println(str);
		System.out.println(ch);
		

	}
	public static void change(String str, char ch[])
	{ 
		str="change";
		ch[0]='H';
		
	}

}
