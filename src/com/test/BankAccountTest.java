package com.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.runner.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest{

	int a1=5;
	int b1=6;
	public BankAccount Bank;
	@Before
	public void setUp() throws Exception {
		Bank=new BankAccount();
		
	}
	
	@Test
	public void addTwotest() {
		assertEquals("assert add method 1",11,Bank.addTwo(a1, b1));
		System.out.println("test mary successfully");
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	
}
