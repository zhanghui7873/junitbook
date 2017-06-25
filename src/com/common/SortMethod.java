package com.common;

public class SortMethod {

	public static int[] array;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = initData();
		// insertSorting(array);
		// quickSorting(array, 0, array.length - 1);
		// middlePartion(array,0,array.length - 1);
		// ShellSort(array);
		// BubbleSort(array);
		//MergeSort(array, 0, array.length - 1);
		//SelectSort(array);
		heapSort(array);
		printArray(array);

	}

	public static int[] initData() {
		array = new int[] { 123, 24, 1, 35, 45, 38, 79, 245, 8 };
		return array;
	}

	// insert
	public static void insertSorting(int[] arary) {
		System.out.println("before:");
		printArray(array);
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j >= 1; j--) {
				if (array[j] > array[j - 1]) {
					swap(array, j, j - 1);
				} else {
					break;
				}
			}
		}
		System.out.println("after:");
		printArray(array);

	}

	public static int partion(int[] array, int low, int high) {

		while (low < high) {
			while ((low < high) && array[low] <= array[high]) {
				high--;
			}
			if (array[low] > array[high]) {
				swap(array, low, high);
				low++;
			}
			while ((low < high) && array[low] <= array[high]) {
				low++;
			}
			if (array[low] > array[high]) {
				swap(array, low, high);
				high--;
			}
		}
		return low;
	}

	public static void middlePartion(int[] array, int low, int high) {
		int privot;
		int index0 = low;
		int index1 = high;
		if (low < high) {
			privot = (low + high) / 2;
			while (index0 <= index1) {
				while ((index0 < high) && array[privot] < array[index1]) {
					index1--;
				}
				while ((low < index1) && array[index0] < array[privot]) {
					index0++;
				}
				if (index0 <= index1) {
					swap(array, index0, index1);
					index0++;
					index1--;
				}
			}
			if (low < index1) {
				middlePartion(array, low, index1);
			}
			if (index0 < high) {
				middlePartion(array, index0, high);
			}
		}

	}

	public static void quickSorting(int[] array, int low, int high) {
		if (low < high) {
			int flag = partion(array, low, high);
			quickSorting(array, low, flag - 1);
			quickSorting(array, flag + 1, high);
		}

	}
	public static void ShellSort(int[] array) {
		int dis = array.length;
		for (int d = dis / 2; d > 0; d = d / 2) {
			for (int i = 0; i < d; i++) {
				for (int j = i + d; j < dis; j = j + d) {
					if (array[j] < array[j - d]) {
						swap(array, j, j - d);
					}
				}
			}
		}
	}

	public static void BubbleSort(int[] array) {
		int exchange;
		for (int i = 0; i < array.length - 1; i++) {
			exchange = 0;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					exchange++;
				}
			}
			System.out.println(exchange);
			if (exchange == 0) {
				break;
			}

		}
	}

	public static void MergeSort(int[] array, int low, int high) {
		if (low >= high)
			return;
		int center = (low + high) / 2;
		MergeSort(array, low, center);
		MergeSort(array, center + 1, high);
		Merge(array, low, high);
	}
	private static void Merge(int[] array, int low, int high) {
		int[] temp = new int[high - low + 1];
		int k = 0;
		int left = low;
		int right = high;
		int center = (low + high) / 2;
		int middle = center + 1;
		while (left <= center && middle <= right) {
			if (array[left] <= array[middle]) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[middle++];
			}
		}
		while (left <= center) {
			temp[k++] = array[left++];

		}
		while (middle <= right) {
			temp[k++] = array[middle++];
		}

		while (k > 0) {
			array[high--] = temp[k - 1];
			k--;
		}
		printArray(array);
		System.out.println();

	}
    
	public static void SelectSort(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			int minIndex=i;
			for(int j=i;j<array.length;j++)
			{
				if(array[j]<array[minIndex])
				{
					minIndex=j;
				}
			}
			swap(array,i,minIndex);
		}
	}
	
	public static void heapSort(int[] array)
	{
			int len=array.length;
			for(int i=len/2-1;i>=0;i--)
			{
				int left=2*i+1;
				int right=2*i+2;
				if(array[left]<array[i]&&array[right]<array[i]) continue;
				if(array[left]>array[i]&&array[right]<array[i]) swap(array,i,left);
				if(array[left]<array[i]&&array[right]>array[i]) swap(array,i,right);
				if(array[left]>array[i]&&array[right]>array[i]) 
				{
					swap(array,(array[left]>array[right])?left:right,i);
				}
			}
			swap(array,array.length-1,0);
			heapAdjust(array,0,len-2);
			//printArray(array);
		}
		
	
	private static void heapAdjust(int[] array, int start, int end) {
		
		for(int i=start,j=end;j>0;j--,i=start)
		{
			while(i<j)
			{
				int left=2*i+1;
				int right=2*i+2;
				if(left>j) 
				{
					break;
				}
				else
				{
					if(right>j)
					{
						if(array[i]<array[left])
							{
							swap(array,i,left);
							i=left;
							}
						break;
					}
					else
					{
						if(array[left]<array[i]&&array[right]<array[i]) break;
						if(array[left]>array[i]&&array[right]<array[i]){ swap(array,i,left); i=left;}
						if(array[left]<array[i]&&array[right]>array[i]){ swap(array,i,right); i=right;}
						if(array[left]>array[i]&&array[right]>array[i]) 
						{
							if(array[left]>array[right])
							{
								swap(array,i,left); i=left;
							}
							else
							{
								swap(array,i,right); i=right;
							}
						}	
					}
				}
			}
			swap(array,0,j);
//			System.out.println(j);
//			printArray(array);
//			System.out.println();
	}
	}
	public static void printArray(int[] array) {
		if (array == null || array.length == 0) {
			return;
		} else {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
	}
	public static void swap(int[] aaray, int start, int end) {
		int tt = array[start];
		array[start] = array[end];
		array[end] = tt;
	}

}
