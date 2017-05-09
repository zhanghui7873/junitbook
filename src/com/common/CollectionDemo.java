package com.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		//stringSortBylength();
		ListSortBylength();

	}
	
    public static void stringSortBylength()
    {
    	TreeSet ts=new TreeSet(new StringComparator());
    	ts.add("hhh");
    	ts.add("ar");
    	ts.add("asahdal");
    	ts.add("aafdafsa");
    	ts.add("hhdfsdh");
    	ts.add("arfd");
    	ts.add("hhhdd");
    	ts.add("ardd");
    	for(Object str:ts)
    	{
    		System.out.println(str);
    	}
    	
    	
    	
    }
    public static void ListSortBylength()
    {
    	ArrayList<String> ls=new ArrayList<String>( );
    	ls.add("hhh");
    	ls.add("hhh");
    	ls.add("asahdal");
    	ls.add("aafdafsa");
    	ls.add("hhdfsdh");
    	ls.add("arfd");
    	ls.add("hhhdd");
    	ls.add("ardd");
    	Collections.sort(ls, new StringComparator() );
    	for(Object str:ls)
    	{
    		System.out.println(str);
    	}
    	
    	
    }
}
