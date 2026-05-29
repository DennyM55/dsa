package org.learn.streams.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 03 - Intermediate Stream Operations
 * Learn: distinct(), limit(), skip(), sorted()
 * <p>
 * Study this after: P02_BasicStreamExamples
 */
public class P03_IntermediateStreamExamples {

    public static void main(String[] args) {
        System.out.println("=== 03 | INTERMEDIATE STREAM OPERATIONS ===\n");

        List<Integer> numbers = Arrays.asList(5, 2, 8, 2, 9, 1, 5, 5, 3);

        // Example 1: distinct() - Remove duplicates
        System.out.println("1. distinct() - Remove Duplicates:");
        System.out.println("Original: " + numbers);
        System.out.println("Distinct: " + numbers.stream()
                .distinct()
                .toList() + "\n");

        // Example 2: sorted() - Sort values
        System.out.println("2. sorted() - Ascending Order:");
        System.out.println("Sorted: " + numbers.stream()
                .sorted()
                .toList() + "\n");

        // Example 3: sorted(reverse) - Sort descending
        System.out.println("3. sorted(Reverse) - Descending Order:");
        System.out.println("Sorted DESC: " + numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList() + "\n");

        // Example 4: limit() - Take first N elements
        System.out.println("4. limit(3) - First 3 Elements:");
        System.out.println("First 3: " + numbers.stream()
                .limit(3)
                .toList() + "\n");

        // Example 5: skip() - Skip first N elements
        System.out.println("5. skip(3) - Skip First 3 Elements:");
        System.out.println("After skipping 3: " + numbers.stream()
                .skip(3)
                .toList() + "\n");

        // Example 6: Chaining multiple operations
        System.out.println("6. Chain: distinct() + sorted() + limit(3):");
        System.out.println("Result: " + numbers.stream()
                .distinct()
                .sorted()
                .limit(3)
                .toList() + "\n");

        // Example 7: peek() - Debug/inspect values
        System.out.println("7. peek() - Inspect Values During Processing:");
        List<Integer> result = numbers.stream()
                .filter(n -> n > 3)
                .peek(n -> System.out.println("  Processing: " + n))
                .toList();
        System.out.println("Final result: " + result + "\n");

        // Example 8: Chain with Strings
        System.out.println("8. String Operations - Chain Filter + Map + Sorted:");
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "api", "code");
        System.out.println("Words with length > 4, uppercase, sorted:");
        List<String> list = new ArrayList<>();
        for (String w : words) {
            if (w.length() > 4) {
                String upperCase = w.toUpperCase();
                list.add(upperCase);
            }
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list + "\n");
    }
}

