package com.common;

public class findMethod {

	public static void main(String[] args) {
		

	}
    public boolean find(int[][] array, int number)
    {
    	boolean flag=false;
    	
    	int column=array[0].length-1;
    	int row=0;
    	while(row<array.length&&column>=0)
    	{
    		if(array[row][column]==number)
    		{
    			flag=true;
    		}
    		if(array[row][column]>number)
    		{
    			column--;
    		}
    		else
    		{
    			row++;
    		}
    	}
    	return flag;
   
    }
    
    public int[][] init()
    {
    	int[][] testData={
    			{1,2,4,8},
    			{2,6,8,10},
    			{4,9,12,18},
    			{6,13,19,30}	
    	};
    	
    	return testData;
    }
}
