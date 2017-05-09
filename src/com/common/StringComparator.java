package com.common;

import java.util.Comparator;

public class StringComparator implements Comparator<Object> {

	@Override
	public int compare(Object arg0, Object arg1) {
		String ob1=(String) arg0;
		String ob2=(String) arg1;
		 int temp=ob1.length()-ob2.length();
		 if(temp==0)
		 {
			 temp=ob1.compareTo(ob2);
		 }
		return temp;
	}

}
