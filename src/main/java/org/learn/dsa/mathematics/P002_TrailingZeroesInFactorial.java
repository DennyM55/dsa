package org.learn.dsa.mathematics;

// Problem 002: For an integer n, find the number of trailing zeroes in n!.

public class P002_TrailingZeroesInFactorial {

    static int trailingZeroes(int n) {
        int zeroCount = 0;
        long divisor = 5;

        while (divisor <= n) {
            int numberOfFives = (int) (n / divisor);
            zeroCount = zeroCount + numberOfFives;
            divisor = divisor * 5;
        }

        return zeroCount;
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println(trailingZeroes(n));
    }
}