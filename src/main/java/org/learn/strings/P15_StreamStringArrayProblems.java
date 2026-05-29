package org.learn.strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 15 - Stream-Based String and Array Problems
 * Functional programming solutions for strings/arrays using Streams
 * 
 * Study after: All stream fundamentals (P01-P06) + String/Array problems (P12-P14)
 */
public class P15_StreamStringArrayProblems {

    public static void main(String[] args) {
        System.out.println("=== 15 | STREAM-BASED STRING AND ARRAY PROBLEMS ===\n");

        // Problem 1: Reverse string using streams
        System.out.println("1. Reverse String Using Stream:");
        String str1 = "Hello Stream";
        String reversedBetter = new StringBuilder(str1.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining())).reverse().toString();
        System.out.println("Original: " + str1);
        System.out.println("Reversed: " + reversedBetter + "\n");

        // Problem 2: Reverse array using streams
        System.out.println("2. Reverse Array Using Stream:");
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] reversed2 = IntStream.rangeClosed(1, arr2.length)
                .map(i -> arr2[arr2.length - i])
                .toArray();
        System.out.println("Original: " + Arrays.toString(arr2));
        System.out.println("Reversed: " + Arrays.toString(reversed2) + "\n");

        // Problem 3: Count vowels and positions
        System.out.println("3. Count Vowels and Positions (Stream):");
        String str3 = "Hello World";
        String vowels = "aeiouAEIOU";
        long vowelCount = str3.chars()
                .filter(c -> vowels.indexOf(c) >= 0)
                .count();
        System.out.println("String: " + str3);
        System.out.println("Vowel count: " + vowelCount + "\n");

        // Problem 4: Extract acronyms
        System.out.println("4. Extract First Letters (Stream):");
        String[] phrases = {
            "Java Stream API",
            "Data Structures Algorithm",
            "Hello World Java"
        };
        for (String phrase : phrases) {
            String acronym = Arrays.stream(phrase.split(" "))
                    .map(word -> word.substring(0, 1))
                    .collect(Collectors.joining());
            System.out.println(phrase + " -> " + acronym);
        }
        System.out.println();

        // Problem 5: Capitalize words
        System.out.println("5. Capitalize First Letter of Words (Stream):");
        String str5 = "hello world java streams";
        String capitalized = Arrays.stream(str5.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println("Original: " + str5);
        System.out.println("Capitalized: " + capitalized + "\n");

        // Problem 6: Filter and map numbers
        System.out.println("6. Filter and Map Numbers (Stream):");
        int[] arr6 = {5, 15, 3, 20, 8, 25};
        int[] filtered = Arrays.stream(arr6)
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .toArray();
        System.out.println("Original: " + Arrays.toString(arr6));
        System.out.println("Filtered (>10) and doubled: " + Arrays.toString(filtered) + "\n");

        // Problem 7: Remove duplicates using Stream
        System.out.println("7. Remove Duplicates (Stream):");
        int[] arr7 = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        int[] distinct = Arrays.stream(arr7).distinct().toArray();
        System.out.println("Original: " + Arrays.toString(arr7));
        System.out.println("Distinct: " + Arrays.toString(distinct) + "\n");

        // Problem 8: Convert to uppercase
        System.out.println("8. Convert Strings to Uppercase (Stream):");
        String[] words = {"java", "stream", "api", "coding"};
        List<String> uppercase = Arrays.stream(words)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Original: " + Arrays.toString(words));
        System.out.println("Uppercase: " + uppercase + "\n");

        // Problem 9: Sort strings by length
        System.out.println("9. Sort Strings by Length (Stream):");
        String[] words9 = {"a", "hello", "java", "stream", "api", "code"};
        List<String> sortedByLength = Arrays.stream(words9)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Original: " + Arrays.toString(words9));
        System.out.println("Sorted by length: " + sortedByLength + "\n");

        // Problem 10: Group strings by first character
        System.out.println("10. Group Strings by First Character (Stream):");
        String[] words10 = {"apple", "apricot", "banana", "blueberry", "cherry", "carrot"};
        Map<String, List<String>> grouped = Arrays.stream(words10)
                .collect(Collectors.groupingBy(
                        w -> w.substring(0, 1).toUpperCase()
                ));
        System.out.println("Words: " + Arrays.toString(words10));
        grouped.forEach((letter, wordList) -> 
                System.out.println("  " + letter + ": " + wordList)
        );
        System.out.println();

        // Problem 11: Find longest string
        System.out.println("11. Find Longest String (Stream):");
        String[] words11 = {"java", "programming", "stream", "api", "algorithm"};
        Optional<String> longest = Arrays.stream(words11)
                .max(Comparator.comparingInt(String::length));
        System.out.println("Words: " + Arrays.toString(words11));
        System.out.println("Longest: " + longest.orElse("None") + "\n");

        // Problem 12: Character frequency
        System.out.println("12. Character Frequency (Stream):");
        String str12 = "mississippi";
        Map<String, Long> charFreq = Arrays.stream(str12.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("String: " + str12);
        System.out.println("Frequency: " + charFreq + "\n");

        // Problem 13: Average of array
        System.out.println("13. Average of Array (Stream):");
        int[] arr13 = {10, 20, 30, 40, 50};
        double average = Arrays.stream(arr13).average().orElse(0);
        System.out.println("Array: " + Arrays.toString(arr13));
        System.out.println("Average: " + average + "\n");

        // Problem 14: Min and Max
        System.out.println("14. Min and Max of Array (Stream):");
        int[] arr14 = {15, 8, 42, 3, 99, 27};
        int min = Arrays.stream(arr14).min().orElse(-1);
        int max = Arrays.stream(arr14).max().orElse(-1);
        System.out.println("Array: " + Arrays.toString(arr14));
        System.out.println("Min: " + min + ", Max: " + max + "\n");

        // Problem 15: Filter palindromes
        System.out.println("15. Filter Palindromes (Stream):");
        String[] words15 = {"racecar", "hello", "madam", "java", "level"};
        List<String> palindromes = Arrays.stream(words15)
                .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println("Words: " + Arrays.toString(words15));
        System.out.println("Palindromes: " + palindromes + "\n");
    }
}

