package com.mayreh.sus4;

import java.util.*;

class Predef {
    public static void printArray(int[] array) {
        if (array == null) return;
        printArray(Arrays.stream(array).boxed().toArray());
    }

    public static <T> void printArray(T[] array) {
        if (array == null || array.length < 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
