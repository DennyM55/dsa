package org.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Advanced Stream Operations
 * Learn: flatMap(), groupingBy(), partitioningBy(), toMap()
 */
public class AdvancedStreamExamples {

    // Student class for examples
    static class Student {
        String name;
        int grade;
        double gpa;

        Student(String name, int grade, double gpa) {
            this.name = name;
            this.grade = grade;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return name + " (Grade: " + grade + ", GPA: " + String.format("%.2f", gpa) + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ADVANCED STREAM OPERATIONS ===\n");

        // Example 1: flatMap() - Flatten nested lists
        System.out.println("1. flatMap() - Flatten Nested Lists:");
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        System.out.println("Nested: " + nestedLists);
        List<Integer> flattened = nestedLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened + "\n");

        // Example 2: flatMap() with words
        System.out.println("2. flatMap() - Split Strings into Characters:");
        List<String> words = Arrays.asList("hello", "world");
        List<String> chars = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Unique characters: " + chars + "\n");

        // Create sample students
        List<Student> students = Arrays.asList(
                new Student("Alice", 10, 3.8),
                new Student("Bob", 10, 3.5),
                new Student("Charlie", 11, 3.9),
                new Student("David", 11, 3.6),
                new Student("Eve", 12, 3.7)
        );

        // Example 3: groupingBy() - Group by single field
        System.out.println("3. groupingBy() - Group Students by Grade:");
        Map<Integer, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(s -> s.grade));
        byGrade.forEach((grade, studentList) -> {
            System.out.println("Grade " + grade + ": " + studentList);
        });
        System.out.println();

        // Example 4: groupingBy() with counting
        System.out.println("4. groupingBy(counting) - Count Students per Grade:");
        Map<Integer, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(s -> s.grade, Collectors.counting()));
        System.out.println(gradeCount + "\n");

        // Example 5: groupingBy() with mapping
        System.out.println("5. groupingBy(mapping) - Get Student Names by Grade:");
        Map<Integer, List<String>> namesByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.grade,
                        Collectors.mapping(s -> s.name, Collectors.toList())
                ));
        System.out.println(namesByGrade + "\n");

        // Example 6: partitioningBy() - Partition into true/false
        System.out.println("6. partitioningBy() - Partition by GPA >= 3.7:");
        Map<Boolean, List<Student>> byGPA = students.stream()
                .collect(Collectors.partitioningBy(s -> s.gpa >= 3.7));
        System.out.println("GPA >= 3.7: " + byGPA.get(true));
        System.out.println("GPA < 3.7: " + byGPA.get(false) + "\n");

        // Example 7: toMap() - Convert to Map
        System.out.println("7. toMap() - Map Student Name to GPA:");
        Map<String, Double> nameToGPA = students.stream()
                .collect(Collectors.toMap(s -> s.name, s -> s.gpa));
        nameToGPA.forEach((name, gpa) -> System.out.println(name + " -> " + gpa));
        System.out.println();

        // Example 8: Multiple grouping levels
        System.out.println("8. Nested groupingBy() - Group by Grade, then count:");
        Map<Integer, Long> nestedGroup = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.grade,
                        Collectors.counting()
                ));
        nestedGroup.forEach((grade, count) -> System.out.println("Grade " + grade + ": " + count + " students"));
        System.out.println();

        // Example 9: Filter then groupBy
        System.out.println("9. Filter then groupBy() - Grade 10 & 11 students by GPA >= 3.7:");
        Map<Integer, List<String>> filtered = students.stream()
                .filter(s -> s.grade >= 10 && s.grade <= 11)
                .collect(Collectors.groupingBy(
                        s -> s.grade,
                        Collectors.mapping(
                                s -> s.gpa >= 3.7 ? s.name + " (Good)" : s.name,
                                Collectors.toList()
                        )
                ));
        System.out.println(filtered + "\n");
    }
}

