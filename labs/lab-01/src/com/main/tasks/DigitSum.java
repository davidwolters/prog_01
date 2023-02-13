package com.main.tasks;

public class DigitSum {

    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void printDigitSum(int number) {
        System.out.println(getDigitSum(number));
    }
}
