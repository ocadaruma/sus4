package com.mayreh.sus4;

import java.util.*;

import static com.mayreh.sus4.Predef.*;

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> stack = new ArrayList<>();

        while (sc.hasNext()) {
            String c = sc.next();
            switch (c) {
            case "+":
                stack.add(0, stack.remove(0) + stack.remove(0));
                break;
            case "-":
                stack.add(0, (-stack.remove(0)) + stack.remove(0));
                break;
            case "*":
                stack.add(0, stack.remove(0) * stack.remove(0));
                break;
            default:
                stack.add(0, Integer.parseInt(c));
                break;
            }
        }

        System.out.println(stack.get(0));
    }
}
