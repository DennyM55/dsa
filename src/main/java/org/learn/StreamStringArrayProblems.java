package org.learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream-Based String and Array Problems
 * Focusing on Stream API solutions for string/array manipulations
 */
public class StreamStringArrayProblems {

    public static void main(String[] args) {
        System.out.println("=== STREAM-BASED STRING AND ARRAY PROBLEMS ===\n");

        // Problem 1: Reverse string using streams
        System.out.println("1. Reverse String Using Stream:");
        String str1 = "Hello Stream";
        String reversed = str1.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());
        System.out.println("Original: " + str1);
        System.out.println("Reversed (via sorted): " + reversed);
        
        // Better way: use StringBuilder with stream
        String reversedBetter = new StringBuilder(str1.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining())).reverse().toString();
        System.out.println("Reversed (StringBuilder): " + reversedBetter + "\n");

        // Problem 2: Reverse array using streams
        System.out.println("2. Reverse Array Using Stream:");
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] reversed2 = IntStream.rangeClosed(1, arr2.length)
                .map(i -> arr2[arr2.length - i])
                .toArray();
        System.out.println("Original: " + Arrays.toString(arr2));
        System.out.println("Reversed: " + Arrays.toString(reversed2) + "\n");

        // Problem 3: Count vowels and print positions using stream
        System.out.println("3. Count Vowels and Their Positions (Stream):");
        String str3 = "Hello World";
        String vowels = "aeiouAEIOU";
        
        long vowelCount = str3.chars()
                .filter(c -> vowels.indexOf(c) >= 0)
                .count();
        System.out.println("String: " + str3);
        System.out.println("Vowel count: " + vowelCount);
        
        System.out.println("Vowel positions:");
        IntStream.range(0, str3.length())
                .filter(i -> vowels.indexOf(str3.charAt(i)) >= 0)
                .forEach(i -> System.out.println("  Index " + i + ": '" + str3.charAt(i) + "'"));
        System.out.println();

        // Problem 4: Extract first letter of each word (Acronym)
        System.out.println("4. Extract First Letters (Acronym) Using Stream:");
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

        // Problem 5: Uppercase each word's first letter
        System.out.println("5. Capitalize First Letter of Each Word (Stream):");
        String str5 = "hello world java streams";
        String capitalized = Arrays.stream(str5.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println("Original: " + str5);
        System.out.println("Capitalized: " + capitalized + "\n");

        // Problem 6: Filter and map - numbers > 10 and double them
        System.out.println("6. Filter and Map Numbers (Stream):");
        int[] arr6 = {5, 15, 3, 20, 8, 25};
        int[] filtered = Arrays.stream(arr6)
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .toArray();
        System.out.println("Original: " + Arrays.toString(arr6));
        System.out.println("Filtered (>10) and doubled: " + Arrays.toString(filtered) + "\n");

        // Problem 7: Remove duplicates from array using stream
        System.out.println("7. Remove Duplicates from Array (Stream):");
        int[] arr7 = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        int[] distinct = Arrays.stream(arr7)
                .distinct()
                .toArray();
        System.out.println("Original: " + Arrays.toString(arr7));
        System.out.println("Distinct: " + Arrays.toString(distinct) + "\n");

        // Problem 8: Convert strings to uppercase using stream
        System.out.println("8. Convert Strings to Uppercase (Stream):");
        String[] words = {"java", "stream", "api", "coding"};
        List<String> uppercase = Arrays.stream(words)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Original: " + Arrays.toString(words));
        System.out.println("Uppercase: " + uppercase + "\n");

        // Problem 9: Sort strings by length using stream
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

        // Problem 11: Find longest string using stream
        System.out.println("11. Find Longest String (Stream):");
        String[] words11 = {"java", "programming", "stream", "api", "algorithm"};
        Optional<String> longest = Arrays.stream(words11)
                .max(Comparator.comparingInt(String::length));
        System.out.println("Words: " + Arrays.toString(words11));
        System.out.println("Longest: " + longest.orElse("None") + "\n");

        // Problem 12: Character frequency in string using stream
        System.out.println("12. Character Frequency (Stream):");
        String str12 = "mississippi";
        Map<String, Long> charFreq = Arrays.stream(str12.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("String: " + str12);
        System.out.println("Frequency: " + charFreq + "\n");

        // Problem 13: Average of array using stream
        System.out.println("13. Average of Array (Stream):");
        int[] arr13 = {10, 20, 30, 40, 50};
        double average = Arrays.stream(arr13)
                .average()
                .orElse(0);
        System.out.println("Array: " + Arrays.toString(arr13));
        System.out.println("Average: " + average + "\n");

        // Problem 14: Min and Max using stream
        System.out.println("14. Min and Max of Array (Stream):");
        int[] arr14 = {15, 8, 42, 3, 99, 27};
        int min = Arrays.stream(arr14).min().orElse(-1);
        int max = Arrays.stream(arr14).max().orElse(-1);
        System.out.println("Array: " + Arrays.toString(arr14));
        System.out.println("Min: " + min + ", Max: " + max + "\n");

        // Problem 15: Collect integers from string using stream
        System.out.println("15. Extract Integers from String (Stream):");
        String str15 = "abc123def456ghi789";
        List<Integer> numbers = str15.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .map(c -> Integer.parseInt(String.valueOf(c)))
                .collect(Collectors.toList());
        System.out.println("String: " + str15);
        System.out.println("Extracted numbers: " + numbers + "\n");

        // Problem 16: Join array elements with separator using stream
        System.out.println("16. Join Array Elements (Stream):");
        String[] arr16 = {"apple", "banana", "cherry", "date"};
        String joined = Arrays.stream(arr16)
                .collect(Collectors.joining(", "));
        System.out.println("Array: " + Arrays.toString(arr16));
        System.out.println("Joined: " + joined + "\n");

        // Problem 17: Convert string to character list using stream
        System.out.println("17. String to Character List (Stream):");
        String str17 = "hello";
        List<String> chars = str17.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toList());
        System.out.println("String: " + str17);
        System.out.println("Characters: " + chars + "\n");

        // Problem 18: Count words starting with specific character
        System.out.println("18. Count Words Starting with Character (Stream):");
        String[] words18 = {"apple", "apricot", "banana", "avocado", "cherry"};
        long countA = Arrays.stream(words18)
                .filter(w -> w.startsWith("a"))
                .count();
        System.out.println("Words: " + Arrays.toString(words18));
        System.out.println("Words starting with 'a': " + countA + "\n");

        // Problem 19: Palindrome strings using stream
        System.out.println("19. Filter Palindromes (Stream):");
        String[] words19 = {"racecar", "hello", "madam", "java", "level"};
        List<String> palindromes = Arrays.stream(words19)
                .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println("Words: " + Arrays.toString(words19));
        System.out.println("Palindromes: " + palindromes + "\n");
    }
}

