package com.myIO;
import java.io.*;
public class IOdemo1 {

	public static void main(String[] args) throws IOException {
		//read existing file contents
		
		//inputFile();
		//inputDemo2();
		//copyFile();
		//copyFile_Demo2();
		
		//copyImage();
		//readCN();
		//writeCN();
		
		//copyByTrans();
		//writeByBuffer();
		readByBuffer();

	}
	//method read()
	public static void inputFile()
	{
		File existFile=new File("resource/IOreading.txt");
		try {
			FileInputStream fis=new FileInputStream(existFile);
			InputStreamReader isreader=new InputStreamReader((fis));
			int line=0;
			char[] by=new char[1024];
			StringBuffer sb=new StringBuffer();
			try {
				while((line=isreader.read(by))!=-1)
				{
					 sb.append(by);
				}
				System.out.print(sb);
				isreader.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	// show method fis.available()
	public static void inputDemo2() throws IOException
	{
		File existFile=new File("resource/IOreading.txt");
		int line=0;
		int size=0;
		char[] by;
		try {
			FileInputStream fis=new FileInputStream(existFile);
			InputStreamReader isreader=new InputStreamReader((fis));
			
			
				size = fis.available(); //获取文件大小,但当文件比较大时，容易dump. 所以只适用于小的文件读取。
				by=new char[size];
			
			
			StringBuffer sb=new StringBuffer();
			try {
				while((line=isreader.read(by))!=-1)
				{
					 sb.append(by);
					
				}
				System.out.print(sb);
				isreader.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//copyFileTest
	public static void copyFile()
	{
		//copy a file
		
		File existFile=new File("resource/IOreading.txt");
		File newFile=new File("resource/Newreading.txt");
		InputStreamReader fis=null;
		OutputStreamWriter osw=null;
		try {
			fis=new InputStreamReader(new FileInputStream(existFile));
			osw=new OutputStreamWriter(new FileOutputStream(newFile));
			int by=0;
			while((by=fis.read())!=-1)
			{
				osw.write(by);
			}
			
			osw.close();
			fis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	//copy file by buffer
	public static void copyFile_Demo2()
	{
		//copy a file
		
		File existFile=new File("resource/IOreading.txt");
		File newFile=new File("resource/Bufferreading.txt");
		InputStreamReader fis=null;
		OutputStreamWriter osw=null;
		try {
			fis=new InputStreamReader(new FileInputStream(existFile));
			osw=new OutputStreamWriter(new FileOutputStream(newFile));
			int by=0;
			char[] ch=new char[1024];
			while((by=fis.read(ch))!=-1)
			{
				osw.write(ch,0,by);
			}
			
			osw.close();
			fis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	//copy image
	
	public static void copyImage()
	{
		//copy a image
		
		File existFile=new File("resource/image.jpg");
		File newFile=new File("resource/NewImage.jpg");
		//InputStreamReader fis=null;
		BufferedInputStream bfis=null;
		BufferedOutputStream bosw=null;
		//OutputStreamWriter osw=null;
		try {
			
			//fis=new InputStreamReader(new FileInputStream(existFile));
			bfis=new BufferedInputStream(new FileInputStream(existFile));
			//osw=new OutputStreamWriter(new FileOutputStream(newFile));
			bosw=new BufferedOutputStream(new FileOutputStream(newFile));
			int by=0;
			byte[] buf=new byte[1024];
			while((by=bfis.read(buf))!=-1)
			{
				bosw.write(buf,0,by);
				bosw.flush();
			}
			bosw.close();
			bfis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//字节流操作中文数据
	public static void readCN()
	{
		File existFile=new File("resource/CN.txt");
		FileInputStream fis=null;
		try {
			fis=new FileInputStream((existFile));
			byte[] buf=new byte[1024];
			int line=0;
			while((line=fis.read(buf))!=-1)
			{
				String str=new String(buf,0,line); //字节转换成字符串，按照给定的编码表进行编码输出
				System.out.println(str);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//使用InputStreamReader 操作InputStream（字节流），转换成字符流
		public static void readCNbyReader()
		{
			File existFile=new File("resource/CN.txt");
			FileInputStream fis=null;
			InputStreamReader isr=null;
			try {
				fis=new FileInputStream((existFile));
				isr=new InputStreamReader(fis);
				int line=0;
				while((line=isr.read())!=-1)
				{
					
					System.out.println(isr.read());
				}
				isr.close();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void writeCN()
		{
			File existFile=new File("resource/CN.txt");
			FileOutputStream fos=null;
			OutputStreamWriter osw=null;
			try {
				fos=new FileOutputStream((existFile));
				osw=new OutputStreamWriter(fos);
				int line=0;
				osw.write("你好");
				
				osw.close();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void copyByTrans()
		{
			FileWriter fw=null;
			FileReader fr=null;
			try {
				fw=new FileWriter("resource/copyCN.txt");
				fr=new FileReader("resource/CN.txt");
				int line=0;
				char[] ch=new char[1024];
				while((line=fr.read(ch))!=-1)
						{
					       fw.write(ch,0,line);
					       fw.flush();
						}
				
				fr.close();
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void writeByBuffer()
		{
			FileWriter fw=null;
			try {
				fw=new FileWriter("resource/copyCN.txt");
				BufferedWriter bw=new BufferedWriter(fw);
				
				for(int i=0;i<=3;i++)
				{
					bw.write(i+"abc");
					bw.newLine();
					bw.flush();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void readByBuffer()
		{
			FileReader fr=null;
			try {
				fr=new FileReader("resource/copyCN.txt");
				BufferedReader br=new BufferedReader(fr);
				
				String line=null;
				while((line=br.readLine())!=null)
				{
					System.out.println(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
