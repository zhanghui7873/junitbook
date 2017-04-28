package com.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapSort {
	public static HashMap<String, Integer> hm;
	public static List<Map.Entry<String,Integer>> list;
	public static MapComparator com;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    MapSort.InputData();
    MapSort.Print(list);
    MapSort.Mapsorting(list, com);
    MapSort.Print(list);
	}
	public static void InputData()
	{
		 hm=new HashMap<String, Integer>();
		hm.put("zhangsan1", 23);
		hm.put("zhangsan2", 22);
		hm.put("zhangsan3", 18);
		hm.put("zhangsan4", 28);
		hm.put("zhangsan5", 27);
		list=new ArrayList<Map.Entry<String, Integer>>(hm.entrySet());
		
		 
	}
	 public static void Print(List<Map.Entry<String,Integer>> list)
	 {		 
		 for(int i=0;i<list.size();i++)
		 {
			 System.out.println(list.get(i).toString());
		 }
	 }
	 
	 public static void Mapsorting(List<Map.Entry<String,Integer>> list, MapComparator com)
	 {		com=new MapComparator(); 
		 Collections.sort(list, com);
	 }
	  
	 
  
}
