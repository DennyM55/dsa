package org.learn.streams.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 04 - Terminal Stream Operations
 * Learn: collect(), reduce(), count(), max(), min(), etc.
 * 
 * Study this after: P03_IntermediateStreamExamples
 */
public class P04_TerminalStreamExamples {

    public static void main(String[] args) {
        System.out.println("=== 04 | TERMINAL STREAM OPERATIONS ===\n");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Example 1: count() - Count elements
        System.out.println("1. count() - Total Elements:");
        long count = numbers.stream().count();
        System.out.println("Count: " + count + "\n");

        // Example 2: max() - Find maximum
        System.out.println("2. max() - Find Maximum:");
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Max: " + max.orElse(-1) + "\n");

        // Example 3: min() - Find minimum
        System.out.println("3. min() - Find Minimum:");
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Min: " + min.orElse(-1) + "\n");

        // Example 4: reduce() - Sum values
        System.out.println("4. reduce() - Sum All Values:");
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum + "\n");

        // Example 5: reduce() - Product
        System.out.println("5. reduce() - Product of Values:");
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product + "\n");

        // Example 6: forEach() - Iterate over elements
        System.out.println("6. forEach() - Print Each Element:");
        numbers.stream().forEach(n -> System.out.println("  Value: " + n));
        System.out.println();

        // Example 7: anyMatch() - Check if any element matches
        System.out.println("7. anyMatch() - Any number > 35?");
        boolean anyGreaterThan35 = numbers.stream().anyMatch(n -> n > 35);
        System.out.println("Result: " + anyGreaterThan35 + "\n");

        // Example 8: allMatch() - Check if all elements match
        System.out.println("8. allMatch() - All numbers > 5?");
        boolean allGreaterThan5 = numbers.stream().allMatch(n -> n > 5);
        System.out.println("Result: " + allGreaterThan5 + "\n");

        // Example 9: noneMatch() - Check if no elements match
        System.out.println("9. noneMatch() - No numbers < 0?");
        boolean noneLessThanZero = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Result: " + noneLessThanZero + "\n");

        // Example 10: collect() - to List
        System.out.println("10. collect(toList()) - Collect to List:");
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled + "\n");

        // Example 11: collect() - to joining String
        System.out.println("11. collect(joining()) - Join as String:");
        String joined = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined + "\n");

        // Example 12: findFirst() - Get first matching element
        System.out.println("12. findFirst() - First element > 25:");
        Optional<Integer> first = numbers.stream()
                .filter(n -> n > 25)
                .findFirst();
        System.out.println("First: " + first.orElse(-1) + "\n");

        // Example 13: findAny() - Get any matching element
        System.out.println("13. findAny() - Any element > 25:");
        Optional<Integer> any = numbers.stream()
                .filter(n -> n > 25)
                .findAny();
        System.out.println("Any: " + any.orElse(-1) + "\n");
    }
}

