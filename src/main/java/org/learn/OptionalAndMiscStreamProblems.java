package org.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Optional and Miscellaneous Stream Problems
 * Optional handling, search problems, etc.
 */
public class OptionalAndMiscStreamProblems {

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
            return name + " ($" + String.format("%.2f", price) + ", " + 
                   (inStock ? "In Stock" : "Out of Stock") + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== OPTIONAL AND MISCELLANEOUS STREAM PROBLEMS ===\n");

        // Problem 1: Basic Optional usage
        System.out.println("1. Basic Optional Usage:");
        List<String> words = Arrays.asList("java", "stream", "api");
        
        System.out.println("Find first element:");
        Optional<String> first = words.stream().findFirst();
        System.out.println("isPresent: " + first.isPresent());
        System.out.println("Value: " + first.get());
        System.out.println("orElse fallback: " + first.orElse("NOT FOUND") + "\n");

        // Problem 2: Optional with map and filter
        System.out.println("2. Optional with map() and filter():");
        Optional<String> result = words.stream()
                .filter(w -> w.length() > 4)
                .findFirst()
                .map(String::toUpperCase);
        System.out.println("First word with length > 4 (uppercase): " 
                + result.orElse("No word found") + "\n");

        // Problem 3: Optional with ifPresent
        System.out.println("3. Optional with ifPresent():");
        Optional<String> opt = words.stream()
                .filter(w -> w.equals("stream"))
                .findFirst();
        opt.ifPresent(w -> System.out.println("Found: " + w));
        System.out.println();

        // Problem 4: Optional with ifPresentOrElse
        System.out.println("4. Optional with ifPresentOrElse():");
        Optional<String> opt2 = words.stream()
                .filter(w -> w.equals("notfound"))
                .findFirst();
        opt2.ifPresentOrElse(
                w -> System.out.println("Found: " + w),
                () -> System.out.println("Not found in list")
        );
        System.out.println();

        // Problem 5: Optional with orElseGet
        System.out.println("5. Optional with orElseGet():");
        Optional<String> opt3 = words.stream()
                .filter(w -> w.equals("xyz"))
                .findFirst();
        String value = opt3.orElseGet(() -> "DEFAULT_VALUE");
        System.out.println("Value: " + value + "\n");

        // Problem 6: Optional with orElseThrow
        System.out.println("6. Optional with orElseThrow():");
        try {
            Optional<String> opt4 = words.stream()
                    .filter(w -> w.equals("notfound"))
                    .findFirst();
            String val = opt4.orElseThrow(() -> 
                    new IllegalArgumentException("Word not found!"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage() + "\n");
        }

        // Problem 7: Chaining Optional operations
        System.out.println("7. Chaining Optional Operations:");
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 899.99, true),
                new Product(2, "Mouse", 29.99, true),
                new Product(3, "Monitor", 299.99, false),
                new Product(4, "Keyboard", 79.99, true),
                new Product(5, "USB Cable", 9.99, false)
        );
        
        Optional<Double> priceOpt = products.stream()
                .filter(p -> p.name.equals("Laptop"))
                .findFirst()
                .map(p -> p.price);
        
        System.out.println("Laptop price: $" + priceOpt.map(String::valueOf).orElse("Not found"));
        System.out.println();

        // Problem 8: Find product by name using Optional
        System.out.println("8. Find Product by Name Using Optional:");
        String searchName = "Keyboard";
        Optional<Product> product = products.stream()
                .filter(p -> p.name.equals(searchName))
                .findFirst();
        
        if (product.isPresent()) {
            System.out.println("Found: " + product.get());
        } else {
            System.out.println("Product not found");
        }
        System.out.println();

        // Problem 9: Complex Optional chain
        System.out.println("9. Complex Optional Chain:");
        products.stream()
                .filter(p -> p.inStock)
                .filter(p -> p.price < 100)
                .findFirst()
                .ifPresentOrElse(
                        p -> System.out.println("First cheap in-stock product: " + p),
                        () -> System.out.println("No products matching criteria")
                );
        System.out.println();

        // Problem 10: Stream to Optional
        System.out.println("10. Convert Stream to Optional:");
        Optional<String> longestWord = words.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println("Longest word: " + longestWord.orElse("NONE") + "\n");

        // Problem 11: In-stock products
        System.out.println("11. Filter In-Stock Products:");
        List<Product> inStock = products.stream()
                .filter(p -> p.inStock)
                .collect(Collectors.toList());
        System.out.println(inStock + "\n");

        // Problem 12: Calculate total price of in-stock products
        System.out.println("12. Total Price of In-Stock Products:");
        double totalPrice = products.stream()
                .filter(p -> p.inStock)
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("Total: $" + String.format("%.2f", totalPrice) + "\n");

        // Problem 13: Find cheapest in-stock product
        System.out.println("13. Find Cheapest In-Stock Product:");
        Optional<Product> cheapest = products.stream()
                .filter(p -> p.inStock)
                .min(Comparator.comparingDouble(p -> p.price));
        cheapest.ifPresentOrElse(
                p -> System.out.println("Cheapest: " + p),
                () -> System.out.println("No in-stock products")
        );
        System.out.println();

        // Problem 14: Product availability status
        System.out.println("14. Product Availability Status:");
        products.forEach(p -> {
            String status = p.inStock ? "✓ Available" : "✗ Out of Stock";
            System.out.println(p.name + ": " + status);
        });
        System.out.println();

        // Problem 15: Batch wise products
        System.out.println("15. Batch Processing with limit():");
        System.out.println("First 2 products:");
        products.stream()
                .limit(2)
                .forEach(System.out::println);
        System.out.println("\nProducts 3-4 (skip 2, limit 2):");
        products.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
        System.out.println();
    }
}

