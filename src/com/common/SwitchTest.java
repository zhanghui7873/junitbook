package com.common;

public class SwitchTest {
    public static int number;
	public static void main(String[] args) {
		
		printPrime(100);
		
		
	}
  public void TestSwitch(int number)
  {
	  number=10;
	  switch(number)
		{ 
		case 1: 
			System.out.println("one");
		case 10: 
			System.out.println("ten");
		case 5: 
			System.out.println("five");
		default:
			System.out.println("no given number");
		
		}
  }
  public static void printPrime(int Scope)
  {
	  if(Scope<0)
	  {
		  return;
	  }
	 for(int i=1;i<=Scope;i++)
	 {
		 Boolean flag=isPrime(i);
		 if(flag)
		 {
			 System.out.println(i);
		 }
	 }
  }
  
  public static Boolean isPrime(int number)
  { 
	  if(number<2) return false;
	 for(int i=2;i<=Math.sqrt(number);i++)
	 {
		 if(number%i==0)
		 {
			return false;
			 
		 }
	 }
	  return true;
	  
  }
}
