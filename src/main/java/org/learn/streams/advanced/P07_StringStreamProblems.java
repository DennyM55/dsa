package org.learn.streams.advanced;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 07 - String Stream Problems
 * Word counting, character analysis, anagrams
 */
public class P07_StringStreamProblems {

    public static void main(String[] args) {
        System.out.println("=== 07 | STRING STREAM PROBLEMS ===\n");

        // Count word frequency
        System.out.println("1. Count Occurrence of Each Word:");
        String text = "java java stream api stream java";
        Map<String, Long> wordCount = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("Text: " + text);
        System.out.println("Word counts: " + wordCount + "\n");

        // Count character frequency
        System.out.println("2. Count Occurrence of Each Character:");
        String str = "hello world";
        Map<String, Long> charCount = Arrays.stream(str.split(""))
                .filter(ch -> !ch.equals(" "))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("String: " + str);
        System.out.println("Character counts: " + charCount + "\n");

        // Group anagrams
        System.out.println("3. Group Anagrams:");
        String[] words = {"listen", "silent", "hello", "enlist"};
        Map<String, List<String>> anagrams = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> word.chars().sorted()
                               .collect(StringBuilder::new,
                                       (sb, c) -> sb.append((char) c),
                                       StringBuilder::append).toString()
                ));
        System.out.println("Words: " + Arrays.toString(words));
        anagrams.forEach((key, value) -> System.out.println("  " + value));
        System.out.println();
    }
}

