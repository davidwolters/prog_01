package com.main.tests;

import org.junit.Test;

import com.main.tasks.DigitSum;

import static org.junit.Assert.assertEquals;
import static com.main.lib.Logger.*;

import java.util.Map;
import java.util.Map.Entry;

public class DigitSumTest {
    private Map<Integer, Integer> expectedResults = Map.of(
            1001, 2,
            1234, 10,
            0, 0);

    @Test
    public void testDigitSum() {
        startTest("getDigitSum");
        for (Entry<Integer, Integer> set : expectedResults.entrySet()) {
            assertEquals(DigitSum.getDigitSum((int) set.getKey()), (int) set.getValue());
            System.out.println("Here");
        }
    }
}
