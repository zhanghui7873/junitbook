package com.test;

import static org.junit.Assert.*;
import com.common.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo1_Test {
   public Demo1 demo;
	@Before
	public void setUp() throws Exception 
	{
		 demo=new Demo1();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		String str="world";
		char ch[]={'h','e','l','l','0'};
		demo.change(str, ch);
		assertEquals("world",str.toString());
		assertNotEquals("hello",ch.toString());
		
	}

}
