package org.learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * String Coding Problems
 * Reverse, palindrome, longest prefix, vowels, anagrams, etc.
 */
public class StringCodingProblems {

    public static void main(String[] args) {
        System.out.println("=== STRING CODING PROBLEMS ===\n");

        // Problem 1: Reverse a string
        System.out.println("1. Reverse a String:");
        String str1 = "Hello World";
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println("Original: " + str1);
        System.out.println("Reversed: " + reversed + "\n");

        // Problem 2: Reverse string without built-in reverse function
        System.out.println("2. Reverse String Without Built-in Reverse:");
        String str2 = "Java";
        String reversed2 = "";
        for (int i = str2.length() - 1; i >= 0; i--) {
            reversed2 += str2.charAt(i);
        }
        System.out.println("Original: " + str2);
        System.out.println("Reversed: " + reversed2 + "\n");

        // Alternative: Using streams
        System.out.println("2b. Reverse String Using Stream:");
        String str3 = "Stream";
        String reversedStream = str3.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());
        System.out.println("Original: " + str3);
        System.out.println("Reversed (via stream): " + reversedStream);
        // Actually, let's do proper reverse with stream
        String reversedStreamCorrect = new StringBuilder(str3.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining())).reverse().toString();
        System.out.println("Reversed (stream+StringBuilder): " + reversedStreamCorrect + "\n");

        // Problem 3: Check palindrome
        System.out.println("3. Check Palindrome:");
        String[] testStrings = {"racecar", "hello", "madam", "12321", "abc"};
        for (String test : testStrings) {
            String rev = new StringBuilder(test).reverse().toString();
            boolean isPalin = test.equals(rev);
            System.out.println(test + " -> " + (isPalin ? "Palindrome" : "Not Palindrome"));
        }
        System.out.println();

        // Problem 4: Longest common prefix in string array
        System.out.println("4. Longest Common Prefix in String Array:");
        String[][] testArrays = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"hello", "help", "her"},
            {"a"}
        };
        for (String[] arr : testArrays) {
            String prefix = longestCommonPrefix(arr);
            System.out.println(Arrays.toString(arr) + " -> \"" + prefix + "\"");
        }
        System.out.println();

        // Problem 5: Count vowels and print index positions of vowels using Stream
        System.out.println("5. Count and Index Vowels Using Stream:");
        String str5 = "Hello World";
        System.out.println("String: " + str5);
        
        long vowelCount = str5.chars()
                .filter(c -> "aeiouAEIOU".indexOf(c) >= 0)
                .count();
        System.out.println("Vowel count: " + vowelCount);
        
        System.out.println("Vowel positions:");
        IntStream.range(0, str5.length())
                .filter(i -> "aeiouAEIOU".indexOf(str5.charAt(i)) >= 0)
                .forEach(i -> System.out.println("  Index " + i + ": " + str5.charAt(i)));
        System.out.println();

        // Problem 6: Extract first letter of each word using Stream
        System.out.println("6. Extract First Letter of Each Word (Acronym):");
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

        // Problem 7: First non-repeating character (using Stream)
        System.out.println("7. First Non-Repeating Character Using Stream:");
        String str7 = "programming";
        Map<String, Long> charFreq = Arrays.stream(str7.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        String firstNonRepeat = Arrays.stream(str7.split(""))
                .filter(ch -> charFreq.get(ch) == 1)
                .findFirst()
                .orElse("None");
        System.out.println("String: " + str7);
        System.out.println("Frequencies: " + charFreq);
        System.out.println("First non-repeating: " + firstNonRepeat + "\n");

        // Problem 8: First repeating character (using Stream)
        System.out.println("8. First Repeating Character Using Stream:");
        String str8 = "software";
        Set<String> seen = new HashSet<>();
        String firstRepeat = Arrays.stream(str8.split(""))
                .filter(ch -> !seen.add(ch))
                .findFirst()
                .orElse("None");
        System.out.println("String: " + str8);
        System.out.println("First repeating: " + firstRepeat + "\n");

        // Problem 9: Group anagrams (already covered but including here)
        System.out.println("9. Group Anagrams:");
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

        // Problem 10: Character frequency (sorted)
        System.out.println("10. Character Frequency (Sorted by Count):");
        String str10 = "mississippi";
        Map<String, Long> freq = Arrays.stream(str10.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        LinkedHashMap<String, Long> sorted = freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("String: " + str10);
        System.out.println("Frequency (sorted): " + sorted + "\n");
    }

    // Helper method: Longest common prefix
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

