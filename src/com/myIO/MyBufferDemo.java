package com.myIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferDemo {

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("resource/copyCN.txt");
			//BufferedReader br=new BufferedReader(fr);
			//MyBufferReader mbr=new MyBufferReader(fr);
			MyLineNumberReader mbr=new MyLineNumberReader(fr);
			String line=" ";
			while((line=mbr.MyReadLine())!=null)
			{
				System.out.println(mbr.getLineNumber()+": "+line);
			}
			mbr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
