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

        for (int i = 1; i < N; i++) {
            int v = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > v) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = v;
            printArray(A);
        }
    }
}
