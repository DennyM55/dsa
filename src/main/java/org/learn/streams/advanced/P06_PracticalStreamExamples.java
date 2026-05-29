package org.learn.streams.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 06 - Practical Stream Examples
 * Real-world product inventory scenarios
 * 
 * Study after: P05_AdvancedStreamExamples
 */
public class P06_PracticalStreamExamples {

    static class Product {
        int id;
        String name;
        double price;
        boolean inStock;

        Product(int id, String name, double price, boolean inStock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.inStock = inStock;
        }

        @Override
        public String toString() {
            return name + " ($" + String.format("%.2f", price) + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 06 | PRACTICAL STREAM EXAMPLES ===\n");

        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 899.99, true),
                new Product(2, "Mouse", 29.99, true),
                new Product(3, "Monitor", 299.99, false),
                new Product(4, "Keyboard", 79.99, true),
                new Product(5, "USB Cable", 9.99, false)
        );

        // Example 1: Filter expensive products
        System.out.println("1. Expensive Products (>$200):");
        List<String> expensive = products.stream()
                .filter(p -> p.price > 200)
                .map(p -> p.name + " ($" + String.format("%.2f", p.price) + ")")
                .sorted()
                .collect(Collectors.toList());
        expensive.forEach(System.out::println);
        System.out.println();

        // Example 2: Group by in-stock status
        System.out.println("2. Products by Availability:");
        Map<Boolean, List<String>> byStock = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.inStock,
                        Collectors.mapping(p -> p.name, Collectors.toList())
                ));
        System.out.println("In Stock: " + byStock.get(true));
        System.out.println("Out of Stock: " + byStock.get(false) + "\n");

        // Example 3: Total inventory value
        System.out.println("3. Total Inventory Value:");
        double totalValue = products.stream()
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("Total: $" + String.format("%.2f", totalValue) + "\n");

        // Example 4: Find cheapest in-stock
        System.out.println("4. Cheapest In-Stock Product:");
        products.stream()
                .filter(p -> p.inStock)
                .min(Comparator.comparingDouble(p -> p.price))
                .ifPresentOrElse(
                        p -> System.out.println("Cheapest: " + p),
                        () -> System.out.println("No in-stock products")
                );
        System.out.println();
    }
}

