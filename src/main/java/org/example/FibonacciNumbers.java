package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Iterative = " + fibonacciIterative(6));

        System.out.println("Recursive = " + fibonacciRecursive(6));

        System.out.println("DP = " + fibonacciDP(6));
    }

    private static long fibonacciIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be >= 0");
        }
        List<Long> fibonacciNumbers = new ArrayList<>();
        if (n <= 1) {
            return 1L;
        }
        fibonacciNumbers.add(1L);
        fibonacciNumbers.add(1L);

        for (int i = 2; i <= n; i++) {
            fibonacciNumbers.add(fibonacciNumbers.get(i - 1) + fibonacciNumbers.get(i - 2));
        }

        return fibonacciNumbers.get(n-1);
    }

    private static long fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be >= 0");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static long fibonacciDP(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be >= 0");
        }
        Map<Integer, Long> fibonacciNumbers = new HashMap<>();

        if (n <= 1) {
            return n;
        }

        if (fibonacciNumbers.containsKey(n)) {
            return fibonacciNumbers.get(n);
        }

        long fibonacciNumber = fibonacciDP(n - 1) + fibonacciDP(n - 2);
        fibonacciNumbers.put(n, fibonacciNumber);
        return fibonacciNumber;
    }
}