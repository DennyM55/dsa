package org.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Number Stream Problems
 * Finding second highest, duplicates, etc.
 */
public class NumberStreamProblems {

    public static void main(String[] args) {
        System.out.println("=== NUMBER STREAM PROBLEMS ===\n");

        // Problem 1: Find second highest number using Stream
        System.out.println("1. Find Second Highest Number Using Stream:");
        List<Integer> numbers = Arrays.asList(10, 20, 50, 40, 30, 25, 15);
        Integer secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Numbers: " + numbers);
        System.out.println("Second highest: " + secondHighest + "\n");

        // Alternative: Using distinct for duplicate prevention
        System.out.println("1b. Find Second Highest (handling duplicates):");
        List<Integer> numbers2 = Arrays.asList(50, 50, 40, 30, 20, 10);
        Integer secondHighest2 = numbers2.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Numbers: " + numbers2);
        System.out.println("Second highest (distinct): " + secondHighest2 + "\n");

        // Problem 2: Find second most repeated character using Stream
        System.out.println("2. Find Second Most Repeated Character Using Stream:");
        String str = "aabbccddee";
        Map<String, Long> charFreq = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        String secondMostRepeated = charFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Not found");
        
        System.out.println("String: " + str);
        System.out.println("Character frequencies: " + charFreq);
        System.out.println("Second most repeated character: " + secondMostRepeated + "\n");

        // Problem 3: Find removal duplicates from list using Stream
        System.out.println("3. Remove Duplicates from List Using Stream:");
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        List<Integer> uniqueList = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Original: " + listWithDuplicates);
        System.out.println("Without duplicates: " + uniqueList + "\n");

        // Problem 4: Find duplicate elements using Stream
        System.out.println("4. Find Duplicate Elements Using Stream:");
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        Set<Integer> duplicates = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("Original: " + list);
        System.out.println("Duplicate elements: " + duplicates + "\n");

        // Problem 5: Find duplicate elements with their count
        System.out.println("5. Find Duplicate Elements with Their Count:");
        List<Integer> list2 = Arrays.asList(11, 22, 22, 33, 33, 33, 44, 44);
        Map<Integer, Long> duplicateCount = list2.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Original: " + list2);
        System.out.println("Duplicates with count: " + duplicateCount + "\n");

        // Problem 6: Count common elements between two lists
        System.out.println("6. Count Common Elements Between Two Lists:");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> common = list3.stream()
                .filter(list4::contains)
                .collect(Collectors.toList());
        System.out.println("List 1: " + list3);
        System.out.println("List 2: " + list4);
        System.out.println("Common elements: " + common + "\n");

        // Problem 7: Number frequency
        System.out.println("7. Number Frequency:");
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        Map<Integer, Long> numFreq = numbers3.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println("Numbers: " + numbers3);
        System.out.println("Frequency: " + numFreq + "\n");

        // Problem 8: Find numbers greater than average
        System.out.println("8. Find Numbers Greater Than Average:");
        List<Integer> numbers4 = Arrays.asList(10, 20, 30, 40, 50);
        double average = numbers4.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);
        List<Integer> aboveAvg = numbers4.stream()
                .filter(n -> n > average)
                .collect(Collectors.toList());
        System.out.println("Numbers: " + numbers4);
        System.out.println("Average: " + average);
        System.out.println("Greater than average: " + aboveAvg + "\n");

        // Problem 9: Find sum of all squares
        System.out.println("9. Find Sum of All Squares:");
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers5.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Numbers: " + numbers5);
        System.out.println("Sum of squares: " + sumOfSquares + "\n");

        // Problem 10: Partition numbers into even and odd
        System.out.println("10. Partition Numbers into Even and Odd:");
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> evenOdd = numbers6.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Numbers: " + numbers6);
        System.out.println("Even: " + evenOdd.get(true));
        System.out.println("Odd: " + evenOdd.get(false) + "\n");
    }
}

