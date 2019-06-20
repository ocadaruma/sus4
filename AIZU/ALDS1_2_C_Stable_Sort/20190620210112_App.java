package com.mayreh.sus4;

import java.util.*;

import static com.mayreh.sus4.Predef.*;

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] C = new String[N];

        Map<Integer, List<String>> orderMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String c = sc.next();
            C[i] = c;
            int n = Integer.parseInt(c.substring(1));

            List<String> xs = orderMap.getOrDefault(n, new ArrayList<>());
            xs.add(c);
            orderMap.put(n, xs);
        }

        String[] bubbleSorted = Arrays.copyOf(C, C.length);
        bubbleSort(bubbleSorted);
        printArray(bubbleSorted);
        checkStability(orderMap, bubbleSorted);

        String[] selectionSorted = Arrays.copyOf(C, C.length);
        selectionSort(selectionSorted);
        printArray(selectionSorted);
        checkStability(orderMap, selectionSorted);
    }

    private static void checkStability(Map<Integer, List<String>> orderMap, String[] sorted) {
        List<String> buffer = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < sorted.length; i++) {
            int n = Integer.parseInt(sorted[i].substring(1));
            if (n > prev) {
                List<String> order = orderMap.get(prev);
                if (order != null && !order.equals(buffer)) {
                    System.out.println("Not stable");
                    return;
                }
                buffer.clear();
                prev = n;
            }
            buffer.add(sorted[i]);
        }
        List<String> order = orderMap.get(prev);
        if (order != null && !order.equals(buffer)) {
            System.out.println("Not stable");
            return;
        }
        System.out.println("Stable");
    }

    private static void bubbleSort(String[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                int left = Integer.parseInt(A[j - 1].substring(1));
                int right = Integer.parseInt(A[j].substring(1));
                if (right < left) {
                    String s = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = s;
                }
            }
        }
    }

    private static void selectionSort(String[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                int value = Integer.parseInt(A[j].substring(1));
                int minValue = Integer.parseInt(A[minIdx].substring(1));
                if (value < minValue) {
                    minIdx = j;
                }
            }
            String min = A[minIdx];
            A[minIdx] = A[i];
            A[i] = min;
        }
    }
}
