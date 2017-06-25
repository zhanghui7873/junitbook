package com.Thread;

public class Thread_demo1 {
	
	public static void main(String[] args) {
		
		
		customer cust1=new customer();
		
		Thread t1=new Thread(cust1);
		Thread t2=new Thread(cust1);
		
          t1.start();
          t2.start();
	}

	

}

class bank
{
	private int sum;
	public synchronized void add(int n)
	{
		sum=sum+n;
		System.out.println(sum);
	}
	
}

class customer implements Runnable
{
	private bank ba=new bank();
	
	@Override
	public  void run() {
		
		for(int i=0;i<=3;i++)
		{
			ba.add(100);
		}
	}
	
}