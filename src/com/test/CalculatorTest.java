package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private static Calculator calculator = new Calculator();

    // 复原操作，表明对每个Test方法测试以后都会进行这个方法操作。
    @Before
    public void setUp() throws Exception {
        calculator.clear();// 结果清零
    }

    @Test
    public void testAdd() {
        // fail("Not yet implemented");
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract() {
        // fail("Not yet implemented");
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
    }

    // 忽略标注，表明这个方法功能还没有实现
    //@Ignore("Multiply() Not yet implemented")
    @Test
    public void testMultiply() {
        fail("Not yet implemented");
    }

    @Test
    public void testDivide() {
        // fail("Not yet implemented");
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

    // Timeout参数表明了你要设定的时间，单位为毫秒，因此1000就代表1秒。
    @Test(timeout = 1000)
    public void squareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());

    }

    /**
     * square1/square2/square3分别用来测试正数，0，复数的平方
     */
    @Test
    public void square1() {
        calculator.square(2);
        assertEquals(4, calculator.getResult());
    }

    @Test
    public void square2() {
        calculator.square(0);
        assertEquals(0, calculator.getResult());
    }

    @Test
    public void square3() {
        calculator.square(-3);
        assertEquals(9, calculator.getResult());
    }

}
