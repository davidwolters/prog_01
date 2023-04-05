package com.main.tests;

import java.security.AlgorithmParameterGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import com.main.tasks.Sort;

import static com.main.lib.Logger.*;

public class SortTest {


    private final int NUM_RAND_LISTS = 10;
    private Random random = new Random(System.currentTimeMillis());

	private int[][] expectedByt = {
			{1, 2, 3},
			{1, 2, 3},
			{3, 2, 1},
			{2, 1, 3},
			{1, 2, 1},
			{1, 1, 2}
	};
	
	private int[][] expectedBS = {
			{1, 2, 3},
			{1, 2, 3},
			{3, 2, 1},
			{1, 2, 3},
			{1, 2, 1},
			{1, 1, 2}
	};

	public void testBytIntill() {

		
		startTest("bytintill");
		for (int i = 0; i < expectedByt.length - 1; i += 2) {
			int[] output = expectedByt[i].clone();
			Sort.bytintill(output);
			test(
					Arrays.toString(expectedByt[i]),
					Arrays.toString(output),
					Arrays.toString(expectedByt[i+1]),
					Arrays.equals(output, expectedByt[i+1])
			);
		}
		endTest();
	}
	
	public void testBubbleSort() {
		startTest("bubblesort");
		for (int i = 0; i < expectedBS.length - 1; i += 2) {
			int[] res = Sort.bubblesort(expectedBS[i]);
			test(
					Arrays.toString(expectedBS[i]),
					Arrays.toString(res),
					Arrays.toString(expectedBS[i+1]),
					Arrays.equals(res, expectedBS[i+1])
			);
		}
		endTest();
	}

    private int[] getRandomList(int length) {
        int[] list = new int[length];

        for (int i = 0; i < length; i++) {
            list[i] = random.nextInt(length);
        }

        return list;
    }


    private int[][] getRandomLists(int length) {
        int[][] lists = new int[NUM_RAND_LISTS][length];

        for (int i = 0; i < NUM_RAND_LISTS; i++) {
            lists[i] = getRandomList(length);
        }

        return lists;
    }


    private long timeBubbleSort(int[][] lists) {
        long start = System.currentTimeMillis();

        for (int[] list : lists) {
        	Sort.bubblesort(list);
        }

        return System.currentTimeMillis() - start;
    }
    	
	private long timeSort(int[][] lists) {
		long start = System.currentTimeMillis();
        for (int[] list : lists) {
            Arrays.stream(list).sorted().toArray();
        }
        return System.currentTimeMillis() - start;	
	}
	
	public void testSortLimits() {
		startTest("bubblesort vs sort");
		double maxTime = 0;
        int len = 10000;

        while (maxTime < 1) {
            int[][] lists = getRandomLists(len);

            double sTime = ((double) timeSort(lists)) / 1000;
            double bsTime = ((double) timeBubbleSort(lists)) / 1000;

            log("Time to bubblesort " + len + " items: bs(" + bsTime + "), s(" + sTime + ")");
            len += 100;

            maxTime = maxTime < bsTime ? bsTime : maxTime < sTime ? sTime : maxTime;
        }
	}
}
