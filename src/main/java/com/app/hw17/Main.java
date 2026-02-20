package com.app.hw17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> categories = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        Optional<Map.Entry<String, Double>> biggestEntry = categories.entrySet().stream().max((a, b) -> (int) (a.getValue() - b.getValue()));
        if (biggestEntry.isEmpty()) {
            System.out.println("Error!");
            return;
        }
        ;
        System.out.printf("Результат: %s=%.0f", biggestEntry.get().getKey(), biggestEntry.get().getValue());
    }
}
