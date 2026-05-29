package org.learn.streams.concepts;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 01 - Stream API Concepts and Theory
 * START HERE - Covers: What is Stream API, Why introduced, core concepts
 * 
 * Topics:
 * - What is Stream API?
 * - Why was Stream API introduced?
 * - map() vs filter()
 * - map() vs flatMap()
 * - Intermediate vs Terminal operations
 * - Lazy evaluation
 * - Functional interfaces
 * - Lambda expressions
 * - Default methods in interfaces
 * - Optional and its usage
 */
public class P01_StreamConceptsTheory {

    public static void main(String[] args) {
        System.out.println("=== 01 | STREAM API CONCEPTS AND THEORY ===\n");

        // Concept 1: What is Stream API?
        System.out.println("1. What is Stream API?");
        System.out.println("   A Stream is a sequence of elements from a source (collection, array)");
        System.out.println("   that can be processed in a functional style.");
        System.out.println("   Key characteristics:");
        System.out.println("   - Not a data structure, doesn't store data");
        System.out.println("   - Functional in nature");
        System.out.println("   - Lazy - computations on streams don't happen until result is needed");
        System.out.println("   - Immutable - original data is not modified\n");

        // Concept 2: Why was Stream API introduced?
        System.out.println("2. Why was Stream API introduced?");
        System.out.println("   - Enable functional programming in Java");
        System.out.println("   - Enable parallel processing easily");
        System.out.println("   - Improve readability of code");
        System.out.println("   - Support big data operations (filter, map, reduce)");
        System.out.println("   - Make code more declarative (what to do, not how)\n");

        // Demo: Comparison of traditional vs Stream approach
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("3. Traditional vs Stream Approach:");
        System.out.println("   Task: Filter even numbers and square them\n");
        
        System.out.println("   Traditional way:");
        List<Integer> result1 = new java.util.ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                result1.add(num * num);
            }
        }
        System.out.println("   " + result1);
        
        System.out.println("\n   Stream way:");
        List<Integer> result2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("   " + result2 + "\n");

        // Concept 4: Difference between map() and filter()
        System.out.println("4. Difference between map() and filter():");
        System.out.println("   filter() - Selects elements matching a condition");
        System.out.println("            - Reduces stream size based on condition");
        System.out.println("            - Example: filter(n -> n > 5)\n");
        
        System.out.println("   map() - Transforms each element to another value");
        System.out.println("         - Doesn't change stream size");
        System.out.println("         - Example: map(n -> n * 2)\n");
        
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("   Original: " + nums);
        System.out.println("   filter(n > 3): " + 
                nums.stream().filter(n -> n > 3).collect(Collectors.toList()));
        System.out.println("   map(n * 2): " + 
                nums.stream().map(n -> n * 2).collect(Collectors.toList()) + "\n");

        // Concept 5: Difference between map() and flatMap()
        System.out.println("5. Difference between map() and flatMap():");
        System.out.println("   map() - Transforms each element (1-to-1 mapping)");
        System.out.println("   flatMap() - Maps each element to a stream, then flattens all streams\n");
        
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        System.out.println("   Nested list: " + nested);
        System.out.println("   flatMap(): " + 
                nested.stream().flatMap(List::stream).collect(Collectors.toList()) + "\n");

        // Concept 6: Intermediate vs Terminal operations
        System.out.println("6. Intermediate vs Terminal Operations:");
        System.out.println("   Intermediate Operations (return Stream, lazy):");
        System.out.println("   - filter(), map(), flatMap(), sorted(), distinct(), limit(), skip(), peek()\n");
        System.out.println("   Terminal Operations (return final result, trigger execution):");
        System.out.println("   - collect(), forEach(), count(), max(), min(), reduce(), findFirst(),");
        System.out.println("     findAny(), anyMatch(), allMatch(), noneMatch(), toArray()\n");

        // Concept 7: Lazy Evaluation
        System.out.println("7. Lazy Evaluation in Streams:");
        System.out.println("   Streams are lazy - operations are not executed until a terminal");
        System.out.println("   operation is called. Intermediate operations are only executed");
        System.out.println("   when needed to produce the final result.\n");
        
        System.out.println("   Example (with terminal operation):");
        numbers.stream()
                .filter(n -> {
                    System.out.println("   filter called for: " + n);
                    return n > 5;
                })
                .map(n -> {
                    System.out.println("   map called for: " + n);
                    return n * 2;
                })
                .collect(Collectors.toList());
        System.out.println();

        // Concept 8: Functional Interface
        System.out.println("8. What is a Functional Interface?");
        System.out.println("   An interface with exactly ONE abstract method.");
        System.out.println("   @FunctionalInterface annotation can be used to mark it.");
        System.out.println("   Examples: Predicate, Function, Consumer, Supplier, Comparator\n");

        // Concept 9: Lambda Expression
        System.out.println("9. What is a Lambda Expression?");
        System.out.println("   A short inline function without a name.");
        System.out.println("   Syntax: (parameters) -> { body }\n");

        // Concept 10: Optional
        System.out.println("10. What is Optional and why do we use it?");
        System.out.println("    A container that may or may not contain a non-null value.");
        System.out.println("    Methods: isPresent(), get(), orElse(), orElseThrow(),");
        System.out.println("             ifPresent(), ifPresentOrElse(), map(), flatMap()");
        System.out.println("    WHY: Avoids NullPointerException, forces explicit null handling\n");
    }
}

