package org.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Data Transformation Stream Problems
 * Convert list to map, remove duplicates, arrays, etc.
 */
public class DataTransformationStreamProblems {

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
            return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DATA TRANSFORMATION STREAM PROBLEMS ===\n");

        // Problem 1: Convert list to map
        System.out.println("1. Convert List to Map (ID -> Name):");
        List<Person> people = Arrays.asList(
                new Person(1, "Alice", 28),
                new Person(2, "Bob", 35),
                new Person(3, "Charlie", 42),
                new Person(4, "David", 30)
        );
        
        Map<Integer, String> idToName = people.stream()
                .collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println("Result: " + idToName + "\n");

        // Problem 2: Convert list to map with custom key-value
        System.out.println("2. Convert List to Map (Name -> Age):");
        Map<String, Integer> nameToAge = people.stream()
                .collect(Collectors.toMap(p -> p.name, p -> p.age));
        System.out.println("Result: " + nameToAge + "\n");

        // Problem 3: Convert list to map with whole object as value
        System.out.println("3. Convert List to Map (ID -> Person Object):");
        Map<Integer, Person> idToPerson = people.stream()
                .collect(Collectors.toMap(p -> p.id, p -> p));
        System.out.println("Result: " + idToPerson + "\n");

        // Problem 4: Remove duplicates from list
        System.out.println("4. Remove Duplicates from List:");
        List<Integer> listWithDups = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        List<Integer> unique = listWithDups.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Original: " + listWithDups);
        System.out.println("Distinct: " + unique + "\n");

        // Problem 5: Convert list to array
        System.out.println("5. Convert List to Array:");
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        String[] array = list.stream().toArray(String[]::new);
        System.out.println("List: " + list);
        System.out.println("Array: " + Arrays.toString(array) + "\n");

        // Problem 6: Convert array to list
        System.out.println("6. Convert Array to List:");
        String[] arr = {"one", "two", "three", "four"};
        List<String> lst = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("List: " + lst + "\n");

        // Problem 7: String array to list of integers
        System.out.println("7. Convert String Array to List of Integers:");
        String[] numStrings = {"10", "20", "30", "40", "50"};
        List<Integer> intList = Arrays.stream(numStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("String array: " + Arrays.toString(numStrings));
        System.out.println("Integer list: " + intList + "\n");

        // Problem 8: List of objects to list of specific property
        System.out.println("8. Extract Property from List of Objects:");
        List<String> names = people.stream()
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("People: " + people);
        System.out.println("Names: " + names + "\n");

        // Problem 9: Filter and transform in one operation
        System.out.println("9. Filter and Transform (Objects to Names, age > 30):");
        List<String> namesAbove30 = people.stream()
                .filter(p -> p.age > 30)
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("Names of people above 30: " + namesAbove30 + "\n");

        // Problem 10: Group objects and convert to map
        System.out.println("10. Group Objects by Age Group:");
        Map<String, List<Person>> byAgeGroup = people.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.age < 30) return "Young";
                    else if (p.age < 40) return "Middle";
                    else return "Senior";
                }));
        byAgeGroup.forEach((group, plist) -> {
            System.out.println(group + ": " + plist);
        });
        System.out.println();

        // Problem 11: Flatten and collect
        System.out.println("11. Flatten List of Lists:");
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flattened = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Nested: " + nestedList);
        System.out.println("Flattened: " + flattened + "\n");

        // Problem 12: Convert list to set
        System.out.println("12. Convert List to Set (Remove Duplicates):");
        List<Integer> listDups = Arrays.asList(1, 2, 2, 3, 3, 3);
        Set<Integer> setUnique = listDups.stream()
                .collect(Collectors.toSet());
        System.out.println("List: " + listDups);
        System.out.println("Set: " + setUnique + "\n");

        // Problem 13: Convert to comma-separated string
        System.out.println("13. Convert List to Comma-Separated String:");
        List<String> items = Arrays.asList("apple", "banana", "cherry", "date");
        String joined = items.stream()
                .collect(Collectors.joining(", "));
        System.out.println("List: " + items);
        System.out.println("Joined: " + joined + "\n");

        // Problem 14: Multiple collections from single stream
        System.out.println("14. Create Multiple Outputs from Single Stream:");
        List<Person> dataSource = Arrays.asList(
                new Person(1, "Alice", 28),
                new Person(2, "Bob", 35),
                new Person(3, "Charlie", 42)
        );
        
        List<String> names2 = dataSource.stream().map(p -> p.name).collect(Collectors.toList());
        List<Integer> ages = dataSource.stream().map(p -> p.age).collect(Collectors.toList());
        
        System.out.println("Names: " + names2);
        System.out.println("Ages: " + ages + "\n");
    }
}

