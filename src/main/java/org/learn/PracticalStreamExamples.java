package org.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Practical Stream Examples
 * Real-world scenarios combining multiple stream operations
 */
public class PracticalStreamExamples {

    // Product class
    static class Product {
        String name;
        String category;
        double price;
        int stock;

        Product(String name, String category, double price, int stock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }

        @Override
        public String toString() {
            return name + " ($" + String.format("%.2f", price) + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== PRACTICAL STREAM EXAMPLES ===\n");

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 899.99, 5),
                new Product("Mouse", "Electronics", 29.99, 50),
                new Product("Desk", "Furniture", 199.99, 10),
                new Product("Chair", "Furniture", 249.99, 8),
                new Product("Monitor", "Electronics", 299.99, 12),
                new Product("Keyboard", "Electronics", 79.99, 30),
                new Product("Bookshelf", "Furniture", 149.99, 3),
                new Product("Lamp", "Furniture", 49.99, 20)
        );

        // Example 1: Filter expensive products (>$200) and get names
        System.out.println("1. Expensive Products (>$200):");
        List<String> expensive = products.stream()
                .filter(p -> p.price > 200)
                .map(p -> p.name + " (" + String.format("$%.2f", p.price) + ")")
                .sorted()
                .collect(Collectors.toList());
        expensive.forEach(System.out::println);
        System.out.println();

        // Example 2: Low stock products (<=10)
        System.out.println("2. Low Stock Products (<=10):");
        products.stream()
                .filter(p -> p.stock <= 10)
                .sorted((p1, p2) -> Integer.compare(p1.stock, p2.stock))
                .forEach(p -> System.out.println("  " + p.name + " - Stock: " + p.stock));
        System.out.println();

        // Example 3: Group by category
        System.out.println("3. Products Grouped by Category:");
        Map<String, List<String>> byCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.mapping(p -> p.name, Collectors.toList())
                ));
        byCategory.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });
        System.out.println();

        // Example 4: Average price by category
        System.out.println("4. Average Price by Category:");
        Map<String, Double> avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.averagingDouble(p -> p.price)
                ));
        avgPriceByCategory.forEach((category, avgPrice) -> {
            System.out.println(category + ": $" + String.format("%.2f", avgPrice));
        });
        System.out.println();

        // Example 5: Total inventory value by category
        System.out.println("5. Total Inventory Value by Category:");
        Map<String, Double> inventoryValue = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.summingDouble(p -> p.price * p.stock)
                ));
        inventoryValue.forEach((category, value) -> {
            System.out.println(category + ": $" + String.format("%.2f", value));
        });
        System.out.println();

        // Example 6: Most expensive product in each category
        System.out.println("6. Most Expensive Product in Each Category:");
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy((p1, p2) -> Double.compare(p1.price, p2.price))
                ));
        mostExpensive.forEach((category, productOpt) -> {
            if (productOpt.isPresent()) {
                Product product = productOpt.get();
                System.out.println(category + ": " + product.name + " - $" + 
                        String.format("%.2f", product.price));
            }
        });
        System.out.println();

        // Example 7: Categorize products (In Stock / Low Stock)
        System.out.println("7. Products Partition (Good Stock / Low Stock):");
        Map<Boolean, List<String>> stockStatus = products.stream()
                .collect(Collectors.partitioningBy(
                        p -> p.stock > 20,
                        Collectors.mapping(p -> p.name + " (" + p.stock + ")", Collectors.toList())
                ));
        System.out.println("Good Stock (>20): " + stockStatus.get(true));
        System.out.println("Low Stock (<=20): " + stockStatus.get(false));
        System.out.println();

        // Example 8: Product statistics
        System.out.println("8. Product Price Statistics:");
        System.out.println("Total Products: " + products.stream().count());
        System.out.println("Min Price: $" + String.format("%.2f",
                products.stream().mapToDouble(p -> p.price).min().orElse(0)));
        System.out.println("Max Price: $" + String.format("%.2f",
                products.stream().mapToDouble(p -> p.price).max().orElse(0)));
        System.out.println("Avg Price: $" + String.format("%.2f",
                products.stream().mapToDouble(p -> p.price).average().orElse(0)));
        System.out.println("Total Value: $" + String.format("%.2f",
                products.stream().mapToDouble(p -> p.price * p.stock).sum()));
        System.out.println();

        // Example 9: Search and filtering
        System.out.println("9. Electronics under $100:");
        products.stream()
                .filter(p -> "Electronics".equals(p.category) && p.price < 100)
                .map(p -> p.name + " - $" + String.format("%.2f", p.price))
                .forEach(System.out::println);
        System.out.println();

        // Example 10: Multi-level filtering and mapping
        System.out.println("10. Expensive Furniture (>$100) with Low Stock:");
        List<String> result = products.stream()
                .filter(p -> "Furniture".equals(p.category))
                .filter(p -> p.price > 100)
                .filter(p -> p.stock < 10)
                .map(p -> p.name + " - $" + String.format("%.2f", p.price) + " (Stock: " + p.stock + ")")
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("None found");
        } else {
            result.forEach(System.out::println);
        }
    }
}

