package org.learn.streams.advanced;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 10 - Data Transformation Stream Problems
 * List to Map conversion, flattening, data reshaping
 */
public class P10_DataTransformationStreamProblems {

    static class Person {
        int id;
        String name;
        int age;

        Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 10 | DATA TRANSFORMATION STREAM PROBLEMS ===\n");

        List<Person> people = Arrays.asList(
                new Person(1, "Alice", 28),
                new Person(2, "Bob", 35),
                new Person(3, "Charlie", 42)
        );

        System.out.println("1. Convert List to Map (ID -> Name):");
        Map<Integer, String> idToName = people.stream()
                .collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println(idToName + "\n");

        System.out.println("2. Extract Property from Objects:");
        List<String> names = people.stream()
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("Names: " + names + "\n");

        System.out.println("3. Flatten List of Lists:");
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattened = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened + "\n");

        System.out.println("4. Convert List to Set (Remove Duplicates):");
        List<Integer> withDups = Arrays.asList(1, 2, 2, 3, 3, 3);
        Set<Integer> unique = withDups.stream()
                .collect(Collectors.toSet());
        System.out.println("Original: " + withDups);
        System.out.println("Unique: " + unique + "\n");
    }
}

