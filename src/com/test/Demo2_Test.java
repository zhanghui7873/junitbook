package com.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo2_Test {

	private int num;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		inputData();
		OutResult();
	}

	public void inputData() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void OutResult() {
		System.out.println("square number:" + num * num);
	}

	public static void perm(char[] buf, int start, int end) {

		if (start == end) 
		{
			for (int i = 0; i <= end; i++)
			{
				System.out.print(buf[i]);
			}
			System.out.println();
		} else 
		{

			for (int i = start; i <= end; i++) {

				char temp = buf[start];
				buf[start] = buf[i];
				perm(buf, start + 1, end);// 通过start控制要被输出的字符串，对应作用2
				temp = buf[start];
				buf[start] = buf[i];
				buf[i] = temp;

			}

		}

	}

}
