package com.myIO;

import java.io.IOException;
import java.io.Reader;


public class MyBufferReader {
	private Reader isr; // 持有的流对象
	private char[] buffer = new char[1024]; // 缓冲区内部数组
	private int index = 0; // 定义数组角标索引
	private int count = 0; // 定义变量，记录数组中元素的个数
	public MyBufferReader(Reader isr) {
		super();
		this.isr = isr;
	}

	public int Myread() throws IOException {
		// 通过被缓冲对象的read 方法获取设备上的数据
			if (count == 0) {
				count=isr.read(buffer);
				index = 0;
			}
		if (count < 0)
			{
			return -1;
			}
		char ch = buffer[index];
		index++;
		count--;
		return ch;
	}
	
	public String MyreadLine() throws IOException 
	{
		StringBuffer sb=new StringBuffer();
		
		int ch=0;
		while((ch=Myread())!=-1)
		{
			if(ch=='\r') {
				continue;
				}
			if(ch=='\n'){
				return sb.toString();	
			}
			sb.append((char)ch);
		}
		//如果最后一行有数据，但是没有换行符
		if(sb.length()!=0)
		{
			return sb.toString();
		}
		return null;
	}
	
	public void close()
	{
		if(isr!=null)
		{
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
