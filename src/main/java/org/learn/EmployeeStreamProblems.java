package org.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Employee Stream Problems
 * Grouping, sorting, finding highest salary, etc.
 */
public class EmployeeStreamProblems {

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
        System.out.println("=== EMPLOYEE STREAM PROBLEMS ===\n");

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 75000),
                new Employee("Bob", "HR", 55000),
                new Employee("Charlie", "IT", 65000),
                new Employee("David", "Sales", 60000),
                new Employee("Eve", "HR", 58000),
                new Employee("Frank", "IT", 80000),
                new Employee("Grace", "Sales", 62000),
                new Employee("Henry", "Finance", 70000),
                new Employee("Ivy", "Finance", 72000)
        );

        System.out.println("Employees: " + employees + "\n");

        // Problem 1: Group employees by department
        System.out.println("1. Group Employees by Department:");
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        byDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
        System.out.println();

        // Problem 2: Find highest salary employee by department
        System.out.println("2. Find Highest Salary Employee by Department:");
        Map<String, Optional<Employee>> highestByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))
                ));
        highestByDept.forEach((dept, emp) -> {
            if (emp.isPresent()) {
                System.out.println(dept + ": " + emp.get());
            }
        });
        System.out.println();

        // Problem 3: Sort employees by salary, then name
        System.out.println("3. Sort Employees by Salary (Desc), then Name (Asc):");
        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary)
                        .reversed()
                        .thenComparing(e -> e.name))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println();

        // Problem 4: Count employees by department
        System.out.println("4. Count Employees by Department:");
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        System.out.println(deptCount + "\n");

        // Problem 5: Average salary by department
        System.out.println("5. Average Salary by Department:");
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)
                ));
        avgSalary.forEach((dept, avg) -> 
                System.out.println(dept + ": $" + String.format("%.2f", avg))
        );
        System.out.println();

        // Problem 6: Total salary by department
        System.out.println("6. Total Salary by Department:");
        Map<String, Double> totalSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.summingDouble(e -> e.salary)
                ));
        totalSalary.forEach((dept, total) -> 
                System.out.println(dept + ": $" + String.format("%.2f", total))
        );
        System.out.println();

        // Problem 7: Find employees earning more than average
        System.out.println("7. Find Employees Earning More Than Overall Average:");
        double overallAvg = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0);
        List<Employee> aboveAvg = employees.stream()
                .filter(e -> e.salary > overallAvg)
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                .collect(Collectors.toList());
        System.out.println("Overall average: $" + String.format("%.2f", overallAvg));
        System.out.println("Employees above average: " + aboveAvg + "\n");

        // Problem 8: Department with highest total salary
        System.out.println("8. Department with Highest Total Salary:");
        String deptWithHighestTotal = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.summingDouble(e -> e.salary)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
        System.out.println("Department: " + deptWithHighestTotal + "\n");

        // Problem 9: Get employee names by department
        System.out.println("9. Get Employee Names by Department:");
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.mapping(e -> e.name, Collectors.toList())
                ));
        namesByDept.forEach((dept, names) -> 
                System.out.println(dept + ": " + names)
        );
        System.out.println();

        // Problem 10: Employees with salary in range
        System.out.println("10. Employees with Salary Between $60,000 - $75,000:");
        List<Employee> inRange = employees.stream()
                .filter(e -> e.salary >= 60000 && e.salary <= 75000)
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                .collect(Collectors.toList());
        System.out.println(inRange + "\n");

        // Problem 11: Highest paid employee
        System.out.println("11. Highest Paid Employee:");
        Optional<Employee> highest = employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary));
        highest.ifPresent(System.out::println);
        System.out.println();

        // Problem 12: Department names and employee count
        System.out.println("12. Departments with Employee Count:");
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " employees"));
        System.out.println();
    }
}

