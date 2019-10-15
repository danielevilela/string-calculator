package com.dvilela.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void assertSumEqualsExpected() throws Exception {
        String test = "1,2,5";
        int sum = Util.add(test);
        assertEquals(8,sum);
    }

    @Test
    public void assertSumHandleNewLines() throws Exception {
        String test = "1\\n,2,3";
        int sum = Util.add(test);
        assertEquals(6,sum);
    }

    @Test
    public void assertSumHandleCustomDelimiter() throws Exception {
        String test = "//@\\n2@3@8";
        int sum = Util.add(test);
        assertEquals(13,sum);
    }

    @Test
    public void assertNegativeContainsExpected() {
        String exceptionMessage = "";
        try{
            String test = "1,2,-3,-4";
            Util.add(test);
        } catch (Exception e){
            exceptionMessage = e.getMessage();
        }

       assertEquals("Exception: Negatives not allowed [-3, -4]",exceptionMessage);
    }

    @Test
    public void assertSumIgnoresLargerNumbers() throws Exception {
        String test = "2,1001";
        int sum = Util.add(test);
        assertEquals(2, sum);
    }

    @Test
    public void assertSumArbitraryLengthDelimiters() throws Exception {
        String test = "//***\\n1***2***3”";
        int sum = Util.add(test);
        assertEquals(6, sum);
    }

    @Test
    public void assertSumMultipleDelimiters() throws Exception {
        String test = "//$,@\\n1$2@3";
        int sum = Util.add(test);
        assertEquals(6, sum);
    }
}