package com.stream.intro.stream.api;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class Parallel {

    public static void main(String[] args) {

        List<Product> productList = List.of(
                new Product("Laptop", 1000),
                new Product("Phone", 800),
                new Product("Tablet", 600)
        );

        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        System.out.println("Is Parallel: " + isParallel);

        boolean bigPrice = streamOfCollection
                .map(product -> product.getPrice() * 12)
                .anyMatch(price -> price > 200);
        System.out.println("Has Big Price (>200): " + bigPrice);

        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallelS = intStreamParallel.isParallel();
        System.out.println(isParallelS);

        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallelF = intStreamSequential.isParallel();
        System.out.println(isParallelF);

    }
}
