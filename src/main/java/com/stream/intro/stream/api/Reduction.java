package com.stream.intro.stream.api;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Reduction {

    private static final Logger log = LoggerFactory.getLogger(Reduction.class);


    public static void main(String[] args) {

        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println(reduced);

        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println(reducedTwoParams);

        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParallel);
        //collect() Method
        List<Product> productList = Arrays.asList(
                new Product("potatoes", 23),
                new Product("orange", 14),
                new Product("lemon", 13),
                new Product("bread", 23),
                new Product("sugar", 13)
        );

        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());
        collectorCollection.forEach(System.out::println);
        System.out.println(collectorCollection);

        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString);

        double averagePrice = productList.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println(averagePrice);

        double summingPrice = productList.stream()
                .collect(Collectors.summingDouble(Product::getPrice));

        DoubleSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println(statistics);

        Map<Double, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));
        System.out.println(collectorMapOfLists);

        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

    }
}
