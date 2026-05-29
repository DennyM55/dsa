package org.learn.streams.advanced;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 09 - Employee Stream Problems
 * Grouping by department, salary statistics, sorting
 */
public class P09_EmployeeStreamProblems {

    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " (" + department + ", $" + String.format("%.2f", salary) + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 09 | EMPLOYEE STREAM PROBLEMS ===\n");

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 75000),
                new Employee("Bob", "HR", 55000),
                new Employee("Charlie", "IT", 65000),
                new Employee("David", "Sales", 60000),
                new Employee("Eve", "HR", 58000),
                new Employee("Frank", "IT", 80000)
        );

        System.out.println("1. Group Employees by Department:");
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.department))
                .forEach((dept, empList) -> System.out.println(dept + ": " + empList));
        System.out.println();

        System.out.println("2. Department with Highest Total Salary:");
        String topDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.summingDouble(e -> e.salary)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
        System.out.println("Department: " + topDept + "\n");

        System.out.println("3. Average Salary by Department:");
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e -> e.salary)))
                .forEach((dept, avg) -> System.out.println(dept + ": $" + String.format("%.2f", avg)));
        System.out.println();
    }
}

