package com.igate.demo2.util.test;

import com.igate.demo2.util.Multiply;

import junit.framework.TestCase;

public class Multiply_test extends TestCase
{
	private int x = 0;
	private int y = 0;
	protected void setUp()
	{
		x = 4;
		y = 5;
	}

	protected void tearDown()
	{
		x = 0;
		y = 0;
	}

	public void testMultiply()
	{
		System.out.println("Test use of Multiply class");
		int z = Multiply.twoValues(x, y);
		System.out.println("    Result: " + z);
		assertEquals(20, z);
	}
}