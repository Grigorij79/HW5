package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciNumbers {
   public static List<Long> fibonacciNumbers = new ArrayList<>();
   public static  Map<Integer, Long> fibonacciNumbersDP = new HashMap<>();

    public static void main(String[] args) {
        //Spatial complexity fibonacciIterative - O(1)
        //Temporal difficulty fibonacciIterative - O(n)
        System.out.println("Iterative = " + fibonacciIterative(6));
        //Spatial complexity fibonacciRecursive - O(n)
        //Temporal difficulty fibonacciRecursive - O(2^n)
        System.out.println("Recursive = " + fibonacciRecursive(6));
        //Spatial complexity fibonacciDP - O(n)
        //Temporal difficulty fibonacciDP - O(n)
        System.out.println("DP = " + fibonacciDP(6));

    }

    private static long fibonacciIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be >= 0");
        }
        if (n > 92) {
            throw new IllegalArgumentException("Input should be <= 92");
        }
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
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
        if (n > 92) {
            throw new IllegalArgumentException("Input should be <= 92");
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
        if (n > 92) {
            throw new IllegalArgumentException("Input should be <= 92");
        }
        if (n <= 1) {
            return n;
        }
        if (fibonacciNumbersDP.containsKey(n)) {
            return fibonacciNumbersDP.get(n);
        }
        long fibonacciNumber = fibonacciDP(n - 1) + fibonacciDP(n - 2);
        fibonacciNumbersDP.put(n, fibonacciNumber);
        return fibonacciNumber;
    }
}