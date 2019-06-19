package com.mayreh.sus4;

import java.util.*;

import static com.mayreh.sus4.Predef.*;

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            A[i] = n;
        }

        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            int min = A[minIdx];
            A[minIdx] = A[i];
            A[i] = min;
        }
        printArray(A);
    }
}
