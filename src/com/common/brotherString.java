package com.common;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class brotherString {
public String str1;

	public static void main(String[] args) {
		brotherString bs=new brotherString();
		bs.init();
	}
	public boolean findBrother(String str1,String str2)
	{
		boolean isbrother=true;
		if(str1.length()!=str2.length())
		{
			isbrother=false;
		}
		//method 1: 对两个字符串分别进行字符排序，对比出现的次数
		char[] str1char=str1.toCharArray();
		char[] str2char=str2.toCharArray();
		quickSort(str1char,0,str1.length()-1);
		quickSort(str2char,0,str2.length()-1);
		for(int i=0;i<str1.length();i++)
		{
			if(str1char[i]!=str2char[i])
			{
				isbrother=false;
				break;
			}
		}
		return isbrother;
	}
	private void init()
	{
		File file=new File("resource/brotherString.txt");
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line=" ";
			str1="abc";
			try {
				while((line=br.readLine())!=null)
				{
					if(findBrotherbyMap(str1,line))
					{
						System.out.println(line+" is brother");
					}
					
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void quickSort(char[] ch,int low,int high)
	{
		if(low<high)
		{
			int privot=partion(ch,low,high);
			quickSort(ch,low,privot-1);
			quickSort(ch,privot+1,high);
		}
	}
	private int partion(char[] ch, int low, int high) {
		while(low<high)
		{
			while(low<high&&ch[low]<=ch[high])
			{
				high--;
			}
			if(ch[low]>ch[high])
			{
				swap(ch,low,high);
				low++;
			}
			while(low<high&&ch[low]<=ch[high])
			{
				low++;
			}
			if(ch[low]>ch[high])
			{
				swap(ch,low,high);
				high--;
			}
		}
		return low;
	}
	private void swap(char[] ch, int low, int high) {
		char temp=ch[low];
		ch[low]=ch[high];
		ch[high]=temp;
	}
//byHashMap
	public boolean findBrotherbyMap(String str1,String str2 )
	{
	  boolean isbrother=true;
	  if(str1.length()!=str2.length())
	  { 
		  isbrother=false;
	  }
	  else
	  {
		  HashMap<Character,Integer> hm1=new HashMap<Character,Integer>();
		  HashMap<Character, Integer> hm2=new HashMap<Character,Integer>();
		  char[] str1char=str1.toCharArray();
		  char[] str2char=str2.toCharArray();
		  for(int i=0;i<str1char.length;i++)
		  {
			  if(hm1.containsKey(str1char[i]))
			  {
				  int value=hm1.get(str1char[i]);
				  hm1.put(str1char[i], value+1);
			  }
			  else
			  {
				  hm1.put(str1char[i], 1);
			  }
			  if(hm2.containsKey(str2char[i]))
			  {
				  int value=hm2.get(str2char[i]);
				  hm2.put(str2char[i], value+1);
			  }
			  else
			  {
				  hm2.put(str2char[i], 1);
			  }
		  }
		  if(hm1.size()!=hm2.size())
		  {
			  isbrother=false;
		  }
		  else
		  {
			  Iterator<Character> it=hm1.keySet().iterator();
			  while(it.hasNext()){
				  Character ch=it.next();
				  if(hm1.get(ch)!=hm2.get(ch))
				  {
					  isbrother=false;
					  break;
				  }
			  }
		  }
	  }
	  return isbrother;
	}
}
