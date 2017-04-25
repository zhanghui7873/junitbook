package com.common;

public class SequenceSorting {

	public static void main(String[] args) {
		char[] ch={'1','2','3'};
		SequenceSorting.listAll(ch, 0, ch.length-1);
		

	}
	
    public static void listAll(char ch[],int start, int end)
    {
    	if(ch==null||(start>end))
    	{
    		return;
    	}
    	else
    	{
    		if(start==end)
    		{
    			for(int i=0;i<=end;i++)
    			{
    				System.out.print(ch[i]);
    				
    			}
    			System.out.println();
    		}
    		else
    		{
    			for(int i=start;i<=end;i++)
    			{
    				char temp=ch[start];
    				System.out.println("start="+start+" i="+i);
    				ch[start]=ch[i];
          			ch[i]=temp;
    				listAll(ch,start+1,end);
    				System.out.println("start="+start+" i="+i);
    				temp=ch[start];
    				ch[start]=ch[i];
    				ch[i]=temp;
    				
    				
    			}
    		}
    	}
    }
    
}
