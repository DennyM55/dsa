package org.learn.streams.advanced;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 11 - Optional and Miscellaneous Stream Problems
 * Optional handling, searching, filtering, null-safety
 */
public class P11_OptionalAndMiscStreamProblems {

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
        System.out.println("=== 11 | OPTIONAL AND MISC STREAM PROBLEMS ===\n");

        List<String> words = Arrays.asList("java", "stream", "api");

        System.out.println("1. Optional - Find First Element:");
        Optional<String> first = words.stream()
                .filter(w -> w.length() > 4)
                .findFirst();
        System.out.println("First word with length > 4: " + first.orElse("None") + "\n");

        System.out.println("2. Optional - Map and OrElse:");
        Optional<String> result = words.stream()
                .filter(w -> w.equals("stream"))
                .findFirst()
                .map(String::toUpperCase);
        System.out.println("Stream uppercase: " + result.orElse("Not found") + "\n");

        System.out.println("3. Filter In-Stock Products:");
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 899.99, true),
                new Product(2, "Monitor", 299.99, false),
                new Product(3, "Mouse", 29.99, true)
        );
        List<Product> inStock = products.stream()
                .filter(p -> p.inStock)
                .collect(Collectors.toList());
        System.out.println("In-stock: " + inStock + "\n");

        System.out.println("4. Find Cheapest In-Stock:");
        products.stream()
                .filter(p -> p.inStock)
                .min(Comparator.comparingDouble(p -> p.price))
                .ifPresentOrElse(
                        p -> System.out.println("Cheapest: " + p),
                        () -> System.out.println("None available")
                );
        System.out.println();
    }
}

