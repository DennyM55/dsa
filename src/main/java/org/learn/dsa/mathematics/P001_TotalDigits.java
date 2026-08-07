package org.learn.dsa.mathematics;

// Problem 001: Find the total number of digits required to write all numbers from 1 to n.

import java.util.Scanner;
import java.util.stream.IntStream;

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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(totalDigits(n));
        System.out.println(totalDigitStream(n));
    }

    private static int totalDigitStream(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(String::valueOf)
                .mapToInt(String::length)
                .sum();
    }
}
