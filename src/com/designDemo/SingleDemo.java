package com.designDemo;

public class SingleDemo {
/*
 * method 1: this method is safe when multiple Threads
 */
private static final SingleDemo single=new SingleDemo();
private SingleDemo()
{
}
public static SingleDemo getInstance()
{
	return single;
}
public static void say()
{
	System.out.println("this is test singleton");
}
}
