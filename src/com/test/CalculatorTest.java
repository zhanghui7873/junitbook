package com.test;

import static org.junit.Assert.*;
import com.common.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private  Calculator calculator = new Calculator();

    // å¤�åŽŸæ“�ä½œï¼Œè¡¨æ˜Žå¯¹æ¯�ä¸ªTestæ–¹æ³•æµ‹è¯•ä»¥å�Žéƒ½ä¼šè¿›è¡Œè¿™ä¸ªæ–¹æ³•æ“�ä½œã€‚
    @Before
    public void setUp() throws Exception {
        calculator.clear();// ç»“æžœæ¸…é›¶
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

    // å¿½ç•¥æ ‡æ³¨ï¼Œè¡¨æ˜Žè¿™ä¸ªæ–¹æ³•åŠŸèƒ½è¿˜æ²¡æœ‰å®žçŽ°
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

    // Timeoutå�‚æ•°è¡¨æ˜Žäº†ä½ è¦�è®¾å®šçš„æ—¶é—´ï¼Œå�•ä½�ä¸ºæ¯«ç§’ï¼Œå› æ­¤1000å°±ä»£è¡¨1ç§’ã€‚
    @Test(timeout = 1000)
    public void squareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());

    }

    /**
     * square1/square2/square3åˆ†åˆ«ç”¨æ�¥æµ‹è¯•æ­£æ•°ï¼Œ0ï¼Œå¤�æ•°çš„å¹³æ–¹
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
