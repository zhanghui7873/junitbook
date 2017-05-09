package com.common;

import java.util.ArrayList;
import java.util.List;

public class FloydMethods {
private  List<Integer> vertex;  //the vertex set
private  int[][] weights;
private  int[][] path;



//step 1： Initialize the vertex, and the weights.
public void initialData()
{
	vertex=new ArrayList<Integer>();
	for(int i=1;i<=4;i++)
	{
		vertex.add(i);
	}
	
	weights=intializeMatrix();
    path=new int[vertex.size()][vertex.size()];
	for(int i=0;i<vertex.size();i++)
	{
		for(int j=0;j<vertex.size();j++)
		{			
				path[i][j]=-1;
				if(i==j) path[i][j]=0;
		}
	}
	
}

private int[][] intializeMatrix()
{
	int [][] weightMatrix={
			{0,2,6,4},
			{Integer.MAX_VALUE,0,3,Integer.MAX_VALUE},
			{7,Integer.MAX_VALUE,0,1},
			{5,Integer.MAX_VALUE,12,0}		
	};
	
	return weightMatrix;
}

//step 2: find the path

public void findPath()
{
	for(int k=0;k<vertex.size();k++)
	{
		for(int i=0;i<vertex.size();i++)
		{
			for(int j=0;j<vertex.size();j++)
			{
				if(weights[i][k]!=Integer.MAX_VALUE&&weights[k][j]!=Integer.MAX_VALUE&&(weights[i][j]>=weights[i][k]+weights[k][j]))
				{
					weights[i][j]=weights[i][k]+weights[k][j];
					path[i][j]=vertex.get(k);
					//System.out.println(weights[i][j] +" :"+weights[i][k]+ ": "+weights[k][j]);
					
				}
				
			}
		}
	}
}

public void printPtah()
{
	for(int i=0;i<vertex.size();i++)
	{
		for(int j=0;j<vertex.size();j++)
		{
			if(-1==path[i][j])
			{
				System.out.println("the path from "+vertex.get(i)+" to "+vertex.get(j)+" is not accessed");
			}
			else
			{
				System.out.println("the path from "+vertex.get(i)+" to "+vertex.get(j)+" is "+weights[i][j]);
			}
		}
	}
}
}
