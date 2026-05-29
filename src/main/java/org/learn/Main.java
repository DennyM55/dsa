package org.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 75000, "IT"));
        employees.add(new Employee("Alice", 75000, "IT"));
        employees.add(new Employee("Bob", 45000, "HR"));
        employees.add(new Employee("Charlie", 60000, "Finance"));
        employees.add(new Employee("David", 50000, "Sales"));

        List<String> employeeNames = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.salary > 50000) {
                employeeNames.add(employee.name);
            }
        }

        System.out.println(employeeNames);

        // Stream solution - same result
        Set<String> streamResult = employees.stream()
                .filter(employee -> employee.salary > 50000)
                .map(employee -> employee.name)
                .collect(Collectors.toSet());

        System.out.println(streamResult);
    }

    static  class Employee {
        String name;
        int salary;
        String department;

        Employee(String name, int salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }
    }
}
