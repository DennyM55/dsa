package org.learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scrap {

    public static void main(String[] args) {

        /*
         * STREAM API MAIN IDEA
         *
         * stream() creates a pipeline from a collection.
         *
         * Intermediate operations:
         * - Return another Stream
         * - Are lazy
         * - Do not execute until terminal operation is called
         *
         * Terminal operations:
         * - End the stream
         * - Produce final result
         * - After terminal operation, stream cannot be reused
         */

        intermediateOperations();

        filterDemo();
        mapDemo();
        flatMapDemo();
        sortedDemo();
        distinctDemo();
        limitDemo();
        skipDemo();
        peekDemo();

        terminalOperations();

        collectDemo();
        forEachDemo();
        forEachOrderedDemo();
        countDemo();
        maxDemo();
        minDemo();
        reduceDemo();
        reduceWithoutIdentityDemo();
        findFirstDemo();
        findAnyDemo();
        anyMatchDemo();
        allMatchDemo();
        noneMatchDemo();
        toArrayDemo();

        collectorsDemo();

        collectToSetDemo();
        collectToMapDemo();
        joiningDemo();
        groupingByDemo();
        groupingByWithCountingDemo();
        partitioningByDemo();

        optionalDemo();
        lazyEvaluationDemo();
        streamReuseMistakeDemo();
    }

    static void printTitle(String title) {
        System.out.println("\n========== " + title + " ==========");
    }

    static void intermediateOperations() {
        printTitle("INTERMEDIATE OPERATIONS");

        System.out.println("""
                Intermediate operations:
                - filter()
                - map()
                - flatMap()
                - sorted()
                - distinct()
                - limit()
                - skip()
                - peek()

                Meaning:
                These methods return another Stream.
                They are lazy.
                They wait until terminal operation is called.
                """);
    }

    static void terminalOperations() {
        printTitle("TERMINAL OPERATIONS");

        System.out.println("""
                Terminal operations:
                - collect()
                - forEach()
                - forEachOrdered()
                - count()
                - max()
                - min()
                - reduce()
                - findFirst()
                - findAny()
                - anyMatch()
                - allMatch()
                - noneMatch()
                - toArray()

                Meaning:
                These methods end the stream.
                They produce final output.
                After this, stream is closed.
                """);
    }

    /*
     * INTERMEDIATE OPERATION: filter()
     *
     * Meaning:
     * Keep only elements that match the condition.
     *
     * Input:
     * [1, 2, 3, 4, 5, 6]
     *
     * Logic:
     * Keep only even numbers.
     *
     * Output:
     * [2, 4, 6]
     */
    static void filterDemo() {
        printTitle("filter() - Intermediate");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Even numbers: " + result);
    }

    /*
     * INTERMEDIATE OPERATION: map()
     *
     * Meaning:
     * Convert each element into another value.
     *
     * Input:
     * [1, 2, 3, 4]
     *
     * Logic:
     * Square each number.
     *
     * Output:
     * [1, 4, 9, 16]
     */
    static void mapDemo() {
        printTitle("map() - Intermediate");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Squared numbers: " + result);
    }

    /*
     * INTERMEDIATE OPERATION: flatMap()
     *
     * Meaning:
     * Used when we have nested data.
     * It opens inner collections and merges them into one stream.
     *
     * Input:
     * [[1, 2], [3, 4], [5, 6]]
     *
     * Output:
     * [1, 2, 3, 4, 5, 6]
     */
    static void flatMapDemo() {
        printTitle("flatMap() - Intermediate");

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> result = numbers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Flattened output: " + result);

        // Same logic without stream
        List<Integer> normalResult = new ArrayList<>();

        for (List<Integer> list : numbers) {
            normalResult.addAll(list);
        }

        System.out.println("Without stream: " + normalResult);
    }

    /*
     * INTERMEDIATE OPERATION: sorted()
     *
     * Meaning:
     * Sort elements.
     *
     * sorted()
     * - Natural ascending order
     *
     * sorted(Comparator.reverseOrder())
     * - Descending order
     */
    static void sortedDemo() {
        printTitle("sorted() - Intermediate");

        List<Integer> numbers = Arrays.asList(11, 2, 2, 3, 3, 42, 5, 6);

        List<Integer> ascending = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Ascending : " + ascending);
        System.out.println("Descending: " + descending);
    }

    /*
     * INTERMEDIATE OPERATION: distinct()
     *
     * Meaning:
     * Remove duplicate elements.
     *
     * Internally:
     * Uses equals() and hashCode().
     */
    static void distinctDemo() {
        printTitle("distinct() - Intermediate");

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 42, 5, 6);

        List<Integer> result = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Unique values: " + result);
    }

    /*
     * INTERMEDIATE OPERATION: limit()
     *
     * Meaning:
     * Take only first N elements.
     *
     * Example:
     * limit(3) means take first 3 elements only.
     */
    static void limitDemo() {
        printTitle("limit() - Intermediate");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> result = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("After limit(3): " + result);
    }

    /*
     * INTERMEDIATE OPERATION: skip()
     *
     * Meaning:
     * Skip first N elements.
     *
     * Example:
     * skip(2) means ignore first 2 elements.
     */
    static void skipDemo() {
        printTitle("skip() - Intermediate");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> result = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("After skip(2): " + result);
    }

    /*
     * INTERMEDIATE OPERATION: peek()
     *
     * Meaning:
     * Used mainly for debugging.
     * It allows us to see values while they are moving through the stream.
     *
     * Important:
     * peek() does not run unless terminal operation is present.
     */
    static void peekDemo() {
        printTitle("peek() - Intermediate");

        List<Integer> numbers = Arrays.asList(1, 2, 3);

        List<Integer> result = numbers.stream()
                .peek(n -> System.out.println("Before map: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("After map : " + n))
                .collect(Collectors.toList());

        System.out.println("Final output: " + result);
    }

    /*
     * TERMINAL OPERATION: collect()
     *
     * Meaning:
     * Collect stream result into List, Set, Map, etc.
     *
     * Most common:
     * collect(Collectors.toList())
     */
    static void collectDemo() {
        printTitle("collect() - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Input : " + numbers);
        System.out.println("Collected even numbers: " + result);
    }

    /*
     * TERMINAL OPERATION: forEach()
     *
     * Meaning:
     * Performs action for each element.
     *
     * Common use:
     * Printing, logging, calling another method.
     */
    static void forEachDemo() {
        printTitle("forEach() - Terminal");

        List<String> names = Arrays.asList("Amit", "Ravi", "John");

        names.stream()
                .forEach(name -> System.out.println("Name: " + name));
    }

    /*
     * TERMINAL OPERATION: forEachOrdered()
     *
     * Meaning:
     * Similar to forEach(), but preserves encounter order.
     *
     * Useful mainly with parallel streams.
     */
    static void forEachOrderedDemo() {
        printTitle("forEachOrdered() - Terminal");

        List<String> names = Arrays.asList("Amit", "Ravi", "John");

        names.parallelStream()
                .forEachOrdered(name -> System.out.println("Name: " + name));
    }

    /*
     * TERMINAL OPERATION: count()
     *
     * Meaning:
     * Counts number of elements after stream processing.
     */
    static void countDemo() {
        printTitle("count() - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Input : " + numbers);
        System.out.println("Even count: " + count);
    }

    /*
     * TERMINAL OPERATION: max()
     *
     * Meaning:
     * Finds largest value.
     *
     * Return type:
     * Optional because stream may be empty.
     */
    static void maxDemo() {
        printTitle("max() - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());

        System.out.println("Input : " + numbers);
        System.out.println("Maximum value: " + max.orElse(0));
    }

    /*
     * TERMINAL OPERATION: min()
     *
     * Meaning:
     * Finds smallest value.
     *
     * Return type:
     * Optional because stream may be empty.
     */
    static void minDemo() {
        printTitle("min() - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);

        System.out.println("Input : " + numbers);
        System.out.println("Minimum value: " + min.orElse(0));
    }

    /*
     * TERMINAL OPERATION: reduce()
     *
     * Meaning:
     * Combines many values into one final value.
     *
     * Common examples:
     * sum, product, total salary, total price.
     *
     * reduce(0, Integer::sum)
     *
     * 0 is identity/default value.
     */
    static void reduceDemo() {
        printTitle("reduce() - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Input : " + numbers);
        System.out.println("Sum using reduce: " + sum);
        System.out.println("Product using reduce: " + product);
    }

    /*
     * TERMINAL OPERATION: reduce() without identity
     *
     * Meaning:
     * If we do not give default value, reduce returns Optional.
     *
     * Why Optional?
     * Because stream may be empty.
     */
    static void reduceWithoutIdentityDemo() {
        printTitle("reduce() without identity - Terminal");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);

        System.out.println("Input : " + numbers);
        System.out.println("Sum: " + sum.orElse(0));
    }

    /*
     * TERMINAL OPERATION: findFirst()
     *
     * Meaning:
     * Returns first matching element.
     *
     * Important:
     * It stops after finding the first match.
     * Returns Optional because value may not exist.
     */
    static void findFirstDemo() {
        printTitle("findFirst() - Terminal");

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        Optional<Integer> result = numbers.stream()
                .filter(n -> n > 12)
                .findFirst();

        System.out.println("Input : " + numbers);
        System.out.println("First number > 12: " + result.orElse(0));
    }

    /*
     * TERMINAL OPERATION: findAny()
     *
     * Meaning:
     * Returns any matching element.
     *
     * In normal stream:
     * Usually behaves like findFirst().
     *
     * In parallel stream:
     * Can return any matching element.
     */
    static void findAnyDemo() {
        printTitle("findAny() - Terminal");

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        Optional<Integer> result = numbers.stream()
                .filter(n -> n > 12)
                .findAny();

        System.out.println("Input : " + numbers);
        System.out.println("Any number > 12: " + result.orElse(0));
    }

    /*
     * TERMINAL OPERATION: anyMatch()
     *
     * Meaning:
     * Returns true if at least one element matches the condition.
     *
     * Short-circuit:
     * Stops once it finds one matching element.
     */
    static void anyMatchDemo() {
        printTitle("anyMatch() - Terminal");

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        boolean result = numbers.stream()
                .anyMatch(n -> n > 20);

        System.out.println("Input : " + numbers);
        System.out.println("Is any number > 20? " + result);
    }

    /*
     * TERMINAL OPERATION: allMatch()
     *
     * Meaning:
     * Returns true only if all elements match the condition.
     *
     * Short-circuit:
     * Stops when it finds first failed element.
     */
    static void allMatchDemo() {
        printTitle("allMatch() - Terminal");

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);

        boolean result = numbers.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println("Input : " + numbers);
        System.out.println("Are all numbers even? " + result);
    }

    /*
     * TERMINAL OPERATION: noneMatch()
     *
     * Meaning:
     * Returns true only if no element matches the condition.
     *
     * Example:
     * noneMatch(n -> n < 0)
     * means no number should be negative.
     */
    static void noneMatchDemo() {
        printTitle("noneMatch() - Terminal");

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        boolean result = numbers.stream()
                .noneMatch(n -> n < 0);

        System.out.println("Input : " + numbers);
        System.out.println("No negative numbers? " + result);
    }

    /*
     * TERMINAL OPERATION: toArray()
     *
     * Meaning:
     * Converts stream result into array.
     *
     * Better syntax:
     * toArray(String[]::new)
     *
     * This returns String[] instead of Object[].
     */
    static void toArrayDemo() {
        printTitle("toArray() - Terminal");

        List<String> names = Arrays.asList("Amit", "Ravi", "John");

        String[] result = names.stream()
                .toArray(String[]::new);

        System.out.println("Input : " + names);
        System.out.println("Array : " + Arrays.toString(result));
    }

    static void collectorsDemo() {
        printTitle("COMMON COLLECTORS");

        System.out.println("""
                Collectors are helper methods used inside collect().

                Common collectors:
                - Collectors.toList()
                - Collectors.toSet()
                - Collectors.toMap()
                - Collectors.joining()
                - Collectors.groupingBy()
                - Collectors.counting()
                - Collectors.partitioningBy()
                """);
    }

    /*
     * COLLECTOR: toSet()
     *
     * Meaning:
     * Collect result into Set.
     *
     * Set removes duplicates.
     */
    static void collectToSetDemo() {
        printTitle("Collectors.toSet()");

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4);

        Set<Integer> result = numbers.stream()
                .collect(Collectors.toSet());

        System.out.println("Input : " + numbers);
        System.out.println("Set output: " + result);
    }

    /*
     * COLLECTOR: toMap()
     *
     * Meaning:
     * Collect result into Map.
     *
     * Example:
     * name as key
     * name length as value
     */
    static void collectToMapDemo() {
        printTitle("Collectors.toMap()");

        List<String> names = Arrays.asList("Amit", "Ravi", "John");

        Map<String, Integer> result = names.stream()
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));

        System.out.println("Input : " + names);
        System.out.println("Map output: " + result);
    }

    /*
     * COLLECTOR: joining()
     *
     * Meaning:
     * Joins strings into one String.
     */
    static void joiningDemo() {
        printTitle("Collectors.joining()");

        List<String> names = Arrays.asList("Amit", "Ravi", "John");

        String result = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Input : " + names);
        System.out.println("Joined string: " + result);
    }

    /*
     * COLLECTOR: groupingBy()
     *
     * Meaning:
     * Groups data by a key.
     *
     * Similar to SQL GROUP BY.
     *
     * Example:
     * Group words by word length.
     */
    static void groupingByDemo() {
        printTitle("Collectors.groupingBy()");

        List<String> words = Arrays.asList("hi", "cat", "dog", "java");

        Map<Integer, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(word -> word.length()));

        System.out.println("Input : " + words);
        System.out.println("Grouped by length: " + result);
    }

    /*
     * COLLECTOR: groupingBy() + counting()
     *
     * Meaning:
     * Groups data and counts how many items are in each group.
     *
     * Example:
     * Count how many words have length 2, 3, 4, etc.
     */
    static void groupingByWithCountingDemo() {
        printTitle("Collectors.groupingBy() + Collectors.counting()");

        List<String> words = Arrays.asList("hi", "cat", "dog", "java");

        Map<Integer, Long> result = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.length(),
                        Collectors.counting()
                ));

        System.out.println("Input : " + words);
        System.out.println("Count by length: " + result);
    }

    /*
     * COLLECTOR: partitioningBy()
     *
     * Meaning:
     * Splits data into two groups:
     * true group and false group.
     *
     * Example:
     * Even numbers and odd numbers.
     */
    static void partitioningByDemo() {
        printTitle("Collectors.partitioningBy()");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Input : " + numbers);
        System.out.println("Partitioned by even/odd: " + result);
        System.out.println("Even numbers: " + result.get(true));
        System.out.println("Odd numbers : " + result.get(false));
    }

    /*
     * OPTIONAL
     *
     * Meaning:
     * Optional is a container that may or may not contain a value.
     *
     * Used by:
     * findFirst()
     * findAny()
     * max()
     * min()
     * reduce() without identity
     *
     * Why?
     * Because result may not exist.
     */
    static void optionalDemo() {
        printTitle("Optional handling");

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        Optional<Integer> result = numbers.stream()
                .filter(n -> n > 100)
                .findFirst();

        System.out.println("Input : " + numbers);

        if (result.isPresent()) {
            System.out.println("Value found: " + result.get());
        } else {
            System.out.println("No value found");
        }

        int value = result.orElse(0);
        System.out.println("Using orElse(0): " + value);

        result.ifPresent(n -> System.out.println("This prints only if value is present: " + n));
    }

    /*
     * LAZY EVALUATION
     *
     * Meaning:
     * Intermediate operations do not execute immediately.
     * They execute only when terminal operation is called.
     */
    static void lazyEvaluationDemo() {
        printTitle("Lazy evaluation");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println("Creating stream pipeline...");

        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                });

        System.out.println("No filtering happened yet because there is no terminal operation.");

        List<Integer> result = stream.collect(Collectors.toList());

        System.out.println("Now terminal operation executed.");
        System.out.println("Result: " + result);
    }

    /*
     * STREAM REUSE MISTAKE
     *
     * Meaning:
     * Once terminal operation is called, stream is closed.
     * You cannot reuse the same stream again.
     */
    static void streamReuseMistakeDemo() {
        printTitle("Stream reuse mistake");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Stream<Integer> stream = numbers.stream();

        long count = stream.count();

        System.out.println("Count: " + count);

        /*
         * Wrong:
         *
         * stream.forEach(System.out::println);
         *
         * This will throw:
         * IllegalStateException: stream has already been operated upon or closed
         *
         * Correct:
         * Create a new stream again.
         */

        numbers.stream()
                .forEach(n -> System.out.println("New stream value: " + n));
    }
}