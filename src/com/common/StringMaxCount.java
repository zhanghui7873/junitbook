package com.common;
import java.util.*;
public class StringMaxCount {

	public static void main(String[] args) {
		String s="qeeeejsfajf";
		
		HashMap<Character, Integer> hm=StringMaxCount.Count(s);
		StringMaxCount.MaxResult(hm);

	}
   public static HashMap<Character,Integer> Count(String str)
   {
	   
	   HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
	   if(str==null||str.equals(" "))
	   {
		   System.out.println("please input string");
		   return null;
	   }
	   else
	   {
		   for(int i=0;i<str.length();i++)
		   {
			   Character c=str.charAt(i);
			   int count;
			   if(hm.containsKey(c))
			   {
				    count=hm.get(c)+1;
				   hm.put(c, count);
				   
			   }
			   else
			   {
				   hm.put(c, 1);
			   }
		   }
	   }
	   return hm;
   }
   public static int MaxResult(HashMap<Character,Integer> hm)
   {
	   ArrayList<Integer> list=new ArrayList<Integer>();
	   list.addAll(hm.values()) ;  
	   int max=list.get(0);
	    for(int j=0;j<list.size();j++)
	    {
	    	if(max>=list.get(j))
	    		continue;
	    	else
	    	{
	    		max=list.get(j);
	    	}
	    }
	    for(Map.Entry<Character, Integer> entry: hm.entrySet())
	    {
	    	if(entry.getValue().equals(max))
	    	{
	    		System.out.println("the key is "+entry.getKey()+";the count is "+max);
	    	}
	    }
	   return max;
   }
   
   

}
