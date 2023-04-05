package com.main.tasks;

public class Sort {
    public static boolean bytintill(int[] list) {
        boolean swapped = false;
        for (int i = 1; i < list.length; i++) {
            if (list[i] >= list[i - 1])
                continue;
            int tmp = list[i];
            list[i] = list[i - 1];
            list[i - 1] = tmp;
            swapped = true;
        }

        return swapped;
    }

    public static int[] bubblesort(int[] list) {
        int[] sorted = list.clone();

        while (bytintill(sorted)) {
        }

        return sorted;
    }

}
