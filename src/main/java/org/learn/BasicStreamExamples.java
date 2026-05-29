package org.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic Stream Examples
 * Learn: filter(), map(), collect()
 */
public class BasicStreamExamples {

    public static void main(String[] args) {
        System.out.println("=== BASIC STREAM EXAMPLES ===\n");

        // Example 1: Filter - Select only even numbers
        System.out.println("1. Filter - Even Numbers:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Original: " + numbers);
        System.out.println("Evens: " + evenNumbers + "\n");

        // Example 2: Map - Transform values
        System.out.println("2. Map - Square Numbers:");
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared: " + squared + "\n");

        // Example 3: Filter + Map combined
        System.out.println("3. Filter + Map - Square Even Numbers:");
        List<Integer> squaredEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Even numbers squared: " + squaredEvens + "\n");

        // Example 4: Map to String
        System.out.println("4. Map to String - Convert to Words:");
        List<String> words = Arrays.asList("hello", "world", "stream", "api");
        List<String> upperCase = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCase + "\n");

        // Example 5: Collect to Set (unique values)
        System.out.println("5. Collect to Set - Unique Values:");
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4);
        System.out.println("Original: " + duplicates);
        System.out.println("Unique: " + duplicates.stream()
                .collect(Collectors.toSet()) + "\n");
    }
}

