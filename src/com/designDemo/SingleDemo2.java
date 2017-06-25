package com.designDemo;

public class SingleDemo2 {
private static  SingleDemo2 single=null;
private SingleDemo2()
{
}
synchronized public static SingleDemo2   getInstance()
{
	if(single==null)
	{
		single= new SingleDemo2();
	}
	return single;
}
public static void say()
{
	System.out.println("this is test for singleton");
}
}
