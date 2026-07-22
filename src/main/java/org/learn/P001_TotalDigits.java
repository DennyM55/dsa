package org.learn;

// Problem 001: Find the total number of digits required to write all numbers from 1 to n.

public class P001_TotalDigits {

    static int totalDigits(int n) {
        int total = 0;
        int start = 1;
        int digits = 1;

        while (start <= n) {
            int end = Math.min(n, start * 10 - 1);
            total += (end - start + 1) * digits;

            start *= 10;
            digits++;
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(totalDigits(n));
    }
}
