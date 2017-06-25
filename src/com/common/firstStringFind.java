package com.common;
import java.util.*;

public class firstStringFind {

	public static void main(String[] args) {
		String str="abddflafdj";
		firstStringFind find=new firstStringFind();
		find.findFirst(str);

	}
	// method 1
	public void findFirst(String str)
	{
       if(str==null||str.equals(" "))
       {
    	   return ;
       }
       char[] chararray=str.toCharArray();
       HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
       for(int i=0;i<chararray.length;i++)
       {
    	   if(hm.containsKey(chararray[i]))
    	   {
    		   hm.put(chararray[i], hm.get(chararray[i])+1);
    	   }
    	   else
    	   {
    		   hm.put(chararray[i], 1);
    	   }
       }
       for(int i=0;i<chararray.length;i++)
       { 
    	   if(hm.get(chararray[i])==1)
    	   {
    		   System.out.println("the first char is "+ chararray[i]);
    		   break;
    	   }
       }
       
       
       
	}
	//找到字符中第m个出现n次的字符
	public void find (String str, int m, int n)
	{
		if(str==null||str.equals(" "))
	       {
	    	   return ;
	       }
	       char[] chararray=str.toCharArray();
	       HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
	       for(int i=0;i<chararray.length;i++)
	       {
	    	   if(hm.containsKey(chararray[i]))
	    	   {
	    		   hm.put(chararray[i], hm.get(chararray[i])+1);
	    	   }
	    	   else
	    	   {
	    		   hm.put(chararray[i], 1);
	    	   }
	       }
	       int count=0;
	       
	       if(!hm.containsValue(n))
	       {
	    	   return;
	       }
	       for(int i=0;i<chararray.length;i++)
	       {
	    	   if(hm.get(chararray[i])==n)
	    	   {
	    		   count++;
	    		   if(count<m)
	    		   {
	    			   continue;
	    		   }
	    		   if(count==m)
	    		   {
	    			   System.out.println(chararray[i]);
	    			   break;
	    		   }
	    	   }
	       }
	}
	
}

