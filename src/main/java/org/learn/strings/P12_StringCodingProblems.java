package org.learn.strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 12 - String Coding Problems
 * Master string manipulation: reverse, palindrome, longest prefix, vowels, acronyms, anagrams
 * 
 * Study after: Stream fundamentals (P01-P05)
 */
public class P12_StringCodingProblems {

    public static void main(String[] args) {
        System.out.println("=== 12 | STRING CODING PROBLEMS ===\n");

        // Problem 1: Reverse a string
        System.out.println("1. Reverse a String:");
        String str1 = "Hello World";
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println("Original: " + str1);
        System.out.println("Reversed: " + reversed + "\n");

        // Problem 2: Check palindrome
        System.out.println("2. Check Palindrome:");
        String[] testStrings = {"racecar", "hello", "madam", "12321"};
        for (String test : testStrings) {
            String rev = new StringBuilder(test).reverse().toString();
            boolean isPalin = test.equals(rev);
            System.out.println(test + " -> " + (isPalin ? "Palindrome" : "Not Palindrome"));
        }
        System.out.println();

        // Problem 3: Longest common prefix
        System.out.println("3. Longest Common Prefix:");
        String[][] testArrays = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"hello", "help", "her"}
        };
        for (String[] arr : testArrays) {
            String prefix = longestCommonPrefix(arr);
            System.out.println(Arrays.toString(arr) + " -> \"" + prefix + "\"");
        }
        System.out.println();

        // Problem 4: Count vowels using Stream
        System.out.println("4. Count and Index Vowels (Stream):");
        String str4 = "Hello World";
        System.out.println("String: " + str4);
        
        long vowelCount = str4.chars()
                .filter(c -> "aeiouAEIOU".indexOf(c) >= 0)
                .count();
        System.out.println("Vowel count: " + vowelCount);
        
        System.out.println("Vowel positions:");
        IntStream.range(0, str4.length())
                .filter(i -> "aeiouAEIOU".indexOf(str4.charAt(i)) >= 0)
                .forEach(i -> System.out.println("  Index " + i + ": " + str4.charAt(i)));
        System.out.println();

        // Problem 5: Extract first letters (Acronym)
        System.out.println("5. Extract First Letters (Stream):");
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

        // Problem 6: First non-repeating character
        System.out.println("6. First Non-Repeating Character (Stream):");
        String str6 = "programming";
        Map<String, Long> charFreq = Arrays.stream(str6.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        String firstNonRepeat = Arrays.stream(str6.split(""))
                .filter(ch -> charFreq.get(ch) == 1)
                .findFirst()
                .orElse("None");
        System.out.println("String: " + str6);
        System.out.println("First non-repeating: " + firstNonRepeat + "\n");

        // Problem 7: First repeating character
        System.out.println("7. First Repeating Character (Stream):");
        String str7 = "software";
        Set<String> seen = new HashSet<>();
        String firstRepeat = Arrays.stream(str7.split(""))
                .filter(ch -> !seen.add(ch))
                .findFirst()
                .orElse("None");
        System.out.println("String: " + str7);
        System.out.println("First repeating: " + firstRepeat + "\n");

        // Problem 8: Group anagrams
        System.out.println("8. Group Anagrams:");
        String[] words = {"listen", "silent", "hello", "world", "enlist", "abc", "bca"};
        Map<String, List<String>> anagrams = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                               .sorted()
                               .collect(StringBuilder::new,
                                       (sb, c) -> sb.append((char) c),
                                       StringBuilder::append)
                               .toString()
                ));
        System.out.println("Words: " + Arrays.toString(words));
        anagrams.forEach((key, value) -> System.out.println("  " + value));
        System.out.println();
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

