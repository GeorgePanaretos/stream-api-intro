package com.stream.intro.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LazyInvocation {

    private static long counter;
    private static final Logger log = LoggerFactory.getLogger(LazyInvocation.class);


    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("abc1", "abc2", "abc3","abc4");
        counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });

        System.out.println("Stream created but not processed yet.");
        System.out.println("Applying terminal operation...");
        stream.forEach(System.out::println);
        System.out.println();

        System.out.println("\n---Processing with findFirst()---");
        Optional<String> streamO = list.stream()
                .filter(element -> {
                    System.out.println("filter() was called for: " + element);
                    return element.contains("2");
                })
                .map(element -> {
                    System.out.println("map() was called for: " + element);
                    return element.toUpperCase();
                })
                .findFirst();
        System.out.println("Result from findFirst(): " + streamO.orElse("No match"));


        System.out.println("\n---Processing with skip() before map()---");
        long size2 = list.stream()
                .skip(2)
                .peek(element -> System.out.println("Element after skip:" + element))
                .map(element -> {
                    wasCalled();
                    System.out.println("Mapping element after skip: " + element);
                    return element.substring(0, 3);
                })
                .count();

        System.out.println("Size after skip and then map: " + size2);
    }
}
