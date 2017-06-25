package com.Thread;

public class multiThreaDemo {

	public static void main(String[] args) {
		Resource res=new Resource();
		Producer pro=new Producer(res);
		Consumer con=new Consumer(res);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		t1.start();
		t2.start();
		System.out.println();

	}

}
class Producer implements Runnable{
private Resource res;
Producer(Resource res)
{
	this.res=res;
}
	@Override
	public void run() 
	{
		while(true)
		{
			res.set("面包");
		}
		
		
	}
	
}

class Consumer implements Runnable{
	private Resource res;
	Consumer(Resource res)
	{
		this.res=res;
	}
	@Override
	public void run() {
		while(true)
		{
			res.get();
		}
		
	}
	
}

class Resource
{
	private String name;
	private int count;
	public synchronized void set(String name)
	{
		this.name=name+"---"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"....生产者..."+this.name);
	}
	public synchronized void get()
	{
		
		System.out.println(Thread.currentThread().getName()+"....消费者..."+this.name);
	}
	
	
}