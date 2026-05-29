package org.learn.streams.advanced;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 08 - Number Stream Problems
 * Second highest, duplicates, partitioning
 */
public class P08_NumberStreamProblems {

    public static void main(String[] args) {
        System.out.println("=== 08 | NUMBER STREAM PROBLEMS ===\n");

        List<Integer> numbers = Arrays.asList(10, 20, 50, 40, 30, 25, 15);

        System.out.println("1. Second Highest Number:");
        Integer secondHighest = numbers.stream()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Numbers: " + numbers);
        System.out.println("Second highest: " + secondHighest + "\n");

        System.out.println("2. Find Duplicate Elements:");
        List<Integer> list2 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        Set<Integer> duplicates = list2.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("List: " + list2);
        System.out.println("Duplicates: " + duplicates + "\n");

        System.out.println("3. Partition Even and Odd:");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> evenOdd = list3.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even: " + evenOdd.get(true));
        System.out.println("Odd: " + evenOdd.get(false) + "\n");
    }
}

