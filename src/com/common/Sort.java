package com.common;

public class Sort {

public static int[] array;
public static void main(String args[])
{ Sort s=new Sort();
   array=s.initData();
  //s.insertSort(array);
  //s.selectSort(array);
  //s.bubbleSort(array);
   //s.quickSort(array, 0, array.length-1);
 //  s.mergeSort(array, 0, array.length-1);
   s.HeapSort(array);
  s.print(array);
}
public int[] initData()
{
	array=new int[] {123,45,21,8,76,23,48,56};
	return array;	
}
public void print(int[] array)
{
	for(int i:array)
	{
		System.out.print(" "+i+" ");
	}
	System.out.println();
}
public void swap(int[] array,int i,int j)
{
	int temp=array[i];
	array[i]=array[j];
	array[j]=temp;
}
private void insertSort(int[] array)
{
  for(int i=1;i<array.length;i++)
  {
	  int number=array[i];
	  for(int j=i-1;j>=0;j--)
	  {
		  if(number<array[j])
		  {
			  swap(array,j,j+1);
		  }
		  else
		  {
			  break;
		  }
	  }
  }
}

private void selectSort(int[] array)
{
	for(int i=1;i<array.length;i++)
	{ 
		int maxNumber=array[i];
		int index=i;
		for(int j=i+1;j<array.length;j++)
		{
			if(maxNumber<array[j])
			{
				maxNumber=array[j];
				 index=j;
			}
		}
		if(index!=i)
		{
			swap(array,i,index);
		}
	}
}
 private void bubbleSort(int[] array)
 {
	 for(int i=0;i<array.length;i++)
	 {
		 for(int j=i+1;j<array.length;j++)
		 {
			 if(array[i]>array[j])
			 {
				 swap(array,i,j);
			 }
		 }
	 }
 }
 
 private void quickSort(int[] array,int low,int high)
 {
	 if(low<high)
	 {
		// int flag=firstPartion(array,low,high);
		 int flag=middlePartion(array,low,high);
		 quickSort(array,low, flag-1);
		 quickSort(array,flag+1,high); 
	 }
 }
private int firstPartion(int[] array, int low, int high) {
	
	while(low<high)
	{
		while((low<high)&&array[low]<=array[high])
		{
			high--;
		}
		if(array[low]>array[high])
		{
			swap(array,low,high);
			low++;
		}
		while((low<high)&&(array[low]<=array[high]))
		{
			low++;
		}
		if(array[low]>array[high])
		{
			swap(array,low,high);
			high--;
		}
	}
	return low;
}

private int middlePartion(int[] array, int low, int high)
{
	int middle=(low+high)/2;
	if(array[middle]>array[high]) swap(array,middle,high);
	if(array[low]>array[high]) swap(array,low,high);
	if(array[middle]>array[low])swap(array,middle,low);
	int key=array[low];
	while(low<high)
	{
		while(low<high&&array[high]>=key)
		{
			high--;
		}
		array[low]=array[high];
		while(low<high&&array[low]<=key)
		{
			low++;
		}
		array[high]=array[low];
		
	}
	array[low]=key;
	return low;
}

private void mergeSort(int[] array,int low,int high)
{
	if(low>=high)
		return;
	int middle=(low+high)/2;
	mergeSort(array,low,middle);
	mergeSort(array,middle+1,high);
	Merge(array,low,high);
	
}
private void Merge(int[] array, int low, int high) {
	
	int[] temp=new int[high-low+1];
	int count=0;
	int left=low;
	int middle=(high+low)/2;
	int center=middle+1;
	while(left<=middle&&center<=high)
	{
		if(array[left]<=array[center])
		{
			temp[count++]=array[left++];
		}
		else
		{
			temp[count++]=array[center++];
		}
	}
	while(left<=middle)
	{
		temp[count++]=array[left++];
	}
	
	while(center<=high)
	{
		temp[count++]=array[center++];
	}
	while(count>0)
	{
		array[high--]=temp[count-1];
		count--;
	}
	//print(array);
}
private void HeapSort(int[] array)
{
	int len=array.length;
	for(int i=len/2;i>=0;i--)
	{
		heapAdjust(array,i,len-1);
	}
	
	for(int j=len-1;j>=1;j--)
	{
		swap(array,j,0);	
		heapAdjust(array,0,j-1);
	}
	
}
private void heapAdjust(int[] array, int start, int end)
{
	int left=2*start+1;
	int right=2*start+2;
	int father=start;
	if(left<=end&&array[left]>array[father])
	{
		father=left;
	}
	if(right<=end&&array[right]>array[father])
	{
		father=right;
	}
	if(father!=start)
	{
		swap(array,father,start);	
		heapAdjust(array,father,end);
	}
}

}

