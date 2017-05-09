package com.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMethod {

	
   //输入一行字符，分别统计出其中英文字母，空格，数字和其他字符个数
	public static void StrFrequency(String str)
	{		
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		 char[] ch=str.toCharArray();
		 for(int i=0;i<ch.length;i++)
		 {
			 if(!map.containsKey(ch[i]))
			 {
				 map.put(ch[i], 1);
			 }
			 else
			 {
				 map.put(ch[i], map.get(ch[i])+1);
			 }
		 }
		  List<Map.Entry<Character,Integer>> list=new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		  for(Map.Entry<Character,Integer> item: list)
		  {
			 System.out.println("key:" +item.getKey()+",count:"+item.getValue());
		  }  
	}
	//字符串逆序
	public static void StringReverse(String str)
	{
		StringBuffer sb=new StringBuffer(str);
		sb.reverse();
		System.out.println(sb);
		
	}
	//输出字符串中的所有子串
	public static void substrFinder(String str)
	{
		char[] ch=str.toCharArray();
		//int lastIndex=ch.length-1;
		for(int i=0;i<ch.length;i++)
		{
			for(int j=0,k=ch.length-i;k<=ch.length&&(k-j>=0);j++,k++)
			{
				System.out.println(str.substring(j, k));
			}
		}
	}
	public static void main(String[] args)
	{
		String str="abcd";
		//StrFrequency(str);
	//	StringReverse(str);
		substrFinder(str);
	}
}
