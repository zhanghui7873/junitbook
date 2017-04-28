package com.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoStudent implements Comparable<DemoStudent> {
  private  String name;
  private  int age;
  public DemoStudent(String username,int age)
  {
	  this.setName(username);
	  this.setAge(age);
  }
	public static void main(String[] args) {
		List<DemoStudent> list=new ArrayList<DemoStudent>();
		list.add(new DemoStudent("mary1",21));
		list.add(new DemoStudent("mary2",16));
		list.add(new DemoStudent("mary3",33));
		list.add(new DemoStudent("mary4",12));
		
		Collections.sort(list);
		for(DemoStudent stu:list)
		{
			System.out.println(stu.getName()+" "+stu.getAge());
		}
       
	}
    
	@Override
	public int compareTo(DemoStudent stu1) {
		
		if(stu1==null)
		{
			return 0;
		}
		
		return this.getAge()-stu1.getAge();
	}
	public  String getName() {
		return this.name;
	}
	public  void setName(String name) {
		this.name = name;
	}
	public  int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
