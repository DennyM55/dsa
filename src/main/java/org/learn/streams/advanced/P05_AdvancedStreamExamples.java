package org.learn.streams.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 05 - Advanced Stream Examples
 * Learn: flatMap(), groupingBy(), partitioningBy(), toMap()
 * 
 * Study after: P04_TerminalStreamExamples
 */
public class P05_AdvancedStreamExamples {

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
        System.out.println("=== 05 | ADVANCED STREAM OPERATIONS ===\n");

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

        // Example 2: groupingBy() - Group by single field
        System.out.println("2. groupingBy() - Group Students by Grade:");
        List<Student> students = Arrays.asList(
                new Student("Alice", 10, 3.8),
                new Student("Bob", 10, 3.5),
                new Student("Charlie", 11, 3.9),
                new Student("David", 11, 3.6),
                new Student("Eve", 12, 3.7)
        );
        Map<Integer, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(s -> s.grade));
        byGrade.forEach((grade, studentList) -> {
            System.out.println("Grade " + grade + ": " + studentList);
        });
        System.out.println();

        // Example 3: groupingBy() with counting
        System.out.println("3. groupingBy(counting) - Count Students per Grade:");
        Map<Integer, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(s -> s.grade, Collectors.counting()));
        System.out.println(gradeCount + "\n");

        // Example 4: partitioningBy() - Partition into true/false
        System.out.println("4. partitioningBy() - Partition by GPA >= 3.7:");
        Map<Boolean, List<Student>> byGPA = students.stream()
                .collect(Collectors.partitioningBy(s -> s.gpa >= 3.7));
        System.out.println("GPA >= 3.7: " + byGPA.get(true));
        System.out.println("GPA < 3.7: " + byGPA.get(false) + "\n");

        // Example 5: toMap() - Convert to Map
        System.out.println("5. toMap() - Map Student Name to GPA:");
        Map<String, Double> nameToGPA = students.stream()
                .collect(Collectors.toMap(s -> s.name, s -> s.gpa));
        nameToGPA.forEach((name, gpa) -> System.out.println(name + " -> " + gpa));
        System.out.println();
    }
}

