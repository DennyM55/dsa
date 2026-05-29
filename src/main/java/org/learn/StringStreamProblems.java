package org.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * String Stream Problems
 * Count words, characters, find repeating/non-repeating, anagrams, etc.
 */
public class StringStreamProblems {

    public static void main(String[] args) {
        System.out.println("=== STRING STREAM PROBLEMS ===\n");

        // Problem 1: Count occurrence of each word using Stream
        System.out.println("1. Count Occurrence of Each Word:");
        String text = "java java stream api stream java programming programming";
        String[] words = text.split(" ");
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        w -> w,
                        Collectors.counting()
                ));
        System.out.println("Text: " + text);
        System.out.println("Word counts: " + wordCount + "\n");

        // Problem 2: Count occurrence of each character using Stream
        System.out.println("2. Count Occurrence of Each Character:");
        String str = "hello world";
        Map<String, Long> charCount = Arrays.stream(str.split(""))
                .filter(ch -> !ch.equals(" "))
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        System.out.println("String: " + str);
        System.out.println("Character counts: " + charCount + "\n");

        // Problem 3: Find first non-repeating character using Stream
        System.out.println("3. Find First Non-Repeating Character:");
        String str1 = "programming";
        Map<String, Long> charFreq = Arrays.stream(str1.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        String firstNonRepeating = Arrays.stream(str1.split(""))
                .filter(ch -> charFreq.get(ch) == 1)
                .findFirst()
                .orElse("No non-repeating character found");
        System.out.println("String: " + str1);
        System.out.println("Character frequencies: " + charFreq);
        System.out.println("First non-repeating: " + firstNonRepeating + "\n");

        // Problem 4: Find first repeated character using Stream
        System.out.println("4. Find First Repeated Character:");
        String str2 = "abcdefga";
        Set<String> seen = new HashSet<>();
        String firstRepeating = Arrays.stream(str2.split(""))
                .filter(ch -> !seen.add(ch))
                .findFirst()
                .orElse("No repeated character found");
        System.out.println("String: " + str2);
        System.out.println("First repeated: " + firstRepeating + "\n");

        // Problem 5: Group words by length using Stream
        System.out.println("5. Group Words by Length:");
        String[] wordArray = {"java", "stream", "api", "code", "programming", "is", "fun"};
        Map<Integer, List<String>> wordsByLength = Arrays.stream(wordArray)
                .collect(Collectors.groupingBy(
                        w -> w.length(),
                        Collectors.toList()
                ));
        System.out.println("Words: " + Arrays.toString(wordArray));
        wordsByLength.forEach((length, wordList) -> {
            System.out.println("Length " + length + ": " + wordList);
        });
        System.out.println();

        // Problem 6: Find distinct words starting with # from String array
        System.out.println("6. Find Distinct Words Starting with # from String Array:");
        String[] hashtagWords = {"#java", "#stream", "#java", "#api", "#coding", "#stream"};
        List<String> hashtags = Arrays.stream(hashtagWords)
                .filter(word -> word.startsWith("#"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Words: " + Arrays.toString(hashtagWords));
        System.out.println("Distinct hashtags: " + hashtags + "\n");

        // Problem 7: Group anagrams using Stream
        System.out.println("7. Group Anagrams Using Stream:");
        String[] words2 = {"listen", "silent", "hello", "world", "enlist", "abc", "bca"};
        Map<String, List<String>> anagrams = Arrays.stream(words2)
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                               .sorted()
                               .collect(StringBuilder::new,
                                       (sb, c) -> sb.append((char) c),
                                       StringBuilder::append)
                               .toString()
                ));
        System.out.println("Words: " + Arrays.toString(words2));
        System.out.println("Grouped anagrams: " + anagrams + "\n");

        // Problem 8: Word frequency sorted by count
        System.out.println("8. Word Frequency (Sorted by Count - Descending):");
        String text2 = "stream is awesome stream api is powerful stream";
        Map<String, Long> wordFreq = Arrays.stream(text2.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        
        LinkedHashMap<String, Long> sortedFreq = wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("Text: " + text2);
        System.out.println("Word frequencies (sorted): " + sortedFreq + "\n");

        // Problem 9: Character frequency sorted by count
        System.out.println("9. Character Frequency (Sorted by Count - Descending):");
        String str3 = "mississippi";
        Map<String, Long> charFreq2 = Arrays.stream(str3.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        LinkedHashMap<String, Long> sortedCharFreq = charFreq2.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("String: " + str3);
        System.out.println("Character frequencies (sorted): " + sortedCharFreq + "\n");

        // Problem 10: Count duplicate words
        System.out.println("10. Count Total Duplicate Words (occurring > 1 times):");
        String text3 = "java java stream api stream";
        long duplicateWords = Arrays.stream(text3.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .values()
                .stream()
                .filter(count -> count > 1)
                .count();
        System.out.println("Text: " + text3);
        System.out.println("Number of words with duplicates: " + duplicateWords + "\n");
    }
}

