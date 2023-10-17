package com.sumofdigits;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumOfDigitsTest {

    @Test
    public void testCalSumOfDigits() {

        int result1 = SumOfDigits.calSumOfDigits(123);
        assertEquals(6, result1);

        
        int result2 = SumOfDigits.calSumOfDigits(456789);
        assertEquals(39, result2);

   
        int result3 = SumOfDigits.calSumOfDigits(0);
        assertEquals(0, result3);

        
        int result4 = SumOfDigits.calSumOfDigits(999);
        assertEquals(27, result4);
    }
}