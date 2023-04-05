package com.main.tests;

import static com.main.lib.Logger.*;

import java.util.Map;
import java.util.Map.Entry;

import com.main.tasks.DigitSum;

public class DigitSumTest {
	
	private Map<Integer, Integer> expectedResults = Map.of(
			1001, 2,
			1234, 10,
			0, 0
	);
	
	public void testDigitSum() {
		startTest("getDigitSum");
		for (Entry<Integer, Integer> set : expectedResults.entrySet()) {
			int res = DigitSum.getDigitSum(set.getKey());
			test(""+set.getKey(), ""+res, ""+set.getValue(), res == set.getValue());
		}
		endTest();
	}
}
